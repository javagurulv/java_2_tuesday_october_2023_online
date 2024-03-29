package lv.javaguru.java2.lessoncode.book.app.core.services;

import lv.javaguru.java2.lessoncode.book.app.core.database.jpa.JpaBookRepository;
import lv.javaguru.java2.lessoncode.book.app.core.domain.Book;
import lv.javaguru.java2.lessoncode.book.app.core.responses.CoreError;
import lv.javaguru.java2.lessoncode.book.app.core.responses.SearchBooksResponse;
import lv.javaguru.java2.lessoncode.book.app.core.services.validators.SearchBooksRequestValidator;
import lv.javaguru.java2.lessoncode.book.app.core.requests.Ordering;
import lv.javaguru.java2.lessoncode.book.app.core.requests.Paging;
import lv.javaguru.java2.lessoncode.book.app.core.requests.SearchBooksRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional
public class SearchBooksService {

    @Value("${search.ordering.enabled}")
    private boolean orderingEnabled;

    @Value("${search.paging.enabled}")
    private boolean pagingEnabled;

    @Autowired private JpaBookRepository bookRepository;
    @Autowired private SearchBooksRequestValidator validator;

    public SearchBooksResponse execute(SearchBooksRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new SearchBooksResponse(null, errors);
        }

        List<Book> books = search(request);
        books = order(books, request.getOrdering());
        books = paging(books, request.getPaging());

        return new SearchBooksResponse(books, null);
    }

    private List<Book> order (List < Book > books, Ordering ordering){
        if (orderingEnabled && (ordering != null)) {
            Comparator<Book> comparator = ordering.getOrderBy().equals("title")
                    ? Comparator.comparing(Book::getTitle)
                    : Comparator.comparing(Book::getAuthor);
            if (ordering.getOrderDirection().equals("DESCENDING")) {
                comparator = comparator.reversed();
            }
            return books.stream().sorted(comparator).collect(Collectors.toList());
        } else {
            return books;
        }
    }

    private List<Book> search(SearchBooksRequest request) {
        List<Book> books = new ArrayList<>();
        if (request.isTitleProvided() && !request.isAuthorProvided()) {
            books = bookRepository.findByTitleLike(request.getTitle());
        }
        if (!request.isTitleProvided() && request.isAuthorProvided()) {
            books = bookRepository.findByAuthorLike(request.getAuthor());
        }
        if (request.isTitleProvided() && request.isAuthorProvided()) {
            books = bookRepository.findByTitleAndAuthorLike(request.getTitle(), request.getAuthor());
        }
        return books;
    }

    private List<Book> paging(List<Book> books, Paging paging) {
        if (pagingEnabled && (paging != null)) {
            int skip = (paging.getPageNumber() - 1) * paging.getPageSize();
            return books.stream()
                    .skip(skip)
                    .limit(paging.getPageSize())
                    .collect(Collectors.toList());
        } else {
            return books;
        }
    }

}
