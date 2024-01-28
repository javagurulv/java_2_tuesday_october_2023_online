package lv.javaguru.java2.lessoncode.book.app.core.services;

import lv.javaguru.java2.lessoncode.book.app.core.database.jpa.JpaReaderRepository;
import lv.javaguru.java2.lessoncode.book.app.core.domain.Reader;
import lv.javaguru.java2.lessoncode.book.app.core.requests.Ordering;
import lv.javaguru.java2.lessoncode.book.app.core.requests.Paging;
import lv.javaguru.java2.lessoncode.book.app.core.requests.SearchReadersRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.CoreError;
import lv.javaguru.java2.lessoncode.book.app.core.responses.SearchReadersResponse;
import lv.javaguru.java2.lessoncode.book.app.core.services.validators.SearchReadersRequestValidator;
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
public class SearchReadersService {

    @Value("${search.ordering.enabled}")
    private boolean orderingEnabled;

    @Value("${search.paging.enabled}")
    private boolean pagingEnabled;

    @Autowired private JpaReaderRepository readerRepository;
    @Autowired private SearchReadersRequestValidator validator;

    public SearchReadersResponse execute(SearchReadersRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new SearchReadersResponse(null, errors);
        }

        List<Reader> readers = search(request);
        readers = order(readers, request.getOrdering());
        readers = paging(readers, request.getPaging());

        return new SearchReadersResponse(readers, null);
    }

    private List<Reader> order (List < Reader > readers, Ordering ordering){
        if (orderingEnabled && (ordering != null)) {
            Comparator<Reader> comparator = ordering.getOrderBy().equals("firstName")
                    ? Comparator.comparing(Reader::getFirstName)
                    : Comparator.comparing(Reader::getLastName);
            if (ordering.getOrderDirection().equals("DESCENDING")) {
                comparator = comparator.reversed();
            }
            return readers.stream().sorted(comparator).collect(Collectors.toList());
        } else {
            return readers;
        }
    }

    private List<Reader> search(SearchReadersRequest request) {
        List<Reader> readers = new ArrayList<>();
        if (request.isFirstNameProvided() && !request.isLastNameProvided()) {
            readers = readerRepository.findByFirstNameLike(request.getFirstName());
        }
        if (!request.isFirstNameProvided() && request.isLastNameProvided()) {
            readers = readerRepository.findByLastNameLike(request.getLastName());
        }
        if (request.isFirstNameProvided() && request.isLastNameProvided()) {
            readers = readerRepository.findByFirstNameAndLastNameLike(request.getFirstName(), request.getLastName());
        }
        return readers;
    }

    private List<Reader> paging(List<Reader> readers, Paging paging) {
        if (pagingEnabled && (paging != null)) {
            int skip = (paging.getPageNumber() - 1) * paging.getPageSize();
            return readers.stream()
                    .skip(skip)
                    .limit(paging.getPageSize())
                    .collect(Collectors.toList());
        } else {
            return readers;
        }
    }

}
