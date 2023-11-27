package classWork.core.service;

import classWork.Book;
import classWork.core.database.Database;
import classWork.core.service.valigators.SearchBookValigator;
import classWork.core.response.SearchBooksResponse;
import classWork.core.CoreError;
import classWork.core.requests.SearchBooksRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class SearchBooksService {
   @Autowired SearchBookValigator valigator;
   @Autowired Database data;
    public SearchBooksResponse searchAndSort (SearchBooksRequest request) {
        List<CoreError> errorList = valigator.errorList(request);
        if (!errorList.isEmpty())
            return new SearchBooksResponse(errorList,null);
        List<Book> bookList = searchBook(request);
        List<Book> bookListsorted = sortBookList(request,bookList);
        return new SearchBooksResponse(bookListsorted);
    }

    public List<Book> searchBook (SearchBooksRequest request) {
        List<Book>responceList;
        if (request.getTitle().isEmpty()&&!request.getAuthor().isEmpty()){
            responceList = data.searchByAuthor(request.getAuthor());
        }
        else if (!request.getTitle().isEmpty()&&request.getAuthor().isEmpty()) {
            responceList = data.searchByTitle(request.getTitle());
        }
        else responceList = data.searchByAithorandTitle(request.getAuthor(), request.getTitle());
        return responceList;
    }
    public List<Book> sortBookList (SearchBooksRequest request, List<Book> bookList){

        if (request.getOrdering().getOrderBy().isEmpty()&&request.getOrdering().getOrderDirection().isEmpty()){
            return bookList;}
            Comparator <Book> comparator = request.getOrdering().getOrderBy().equals("по автору")
                    ? Comparator.comparing(Book::getAuthor)
                    : Comparator.comparing(Book::getTitle);
        if(request.getOrdering().getOrderDirection().equals("по убыванию")){
            comparator = comparator.reversed();
        }
        return bookList.stream().sorted(comparator).collect(Collectors.toList());


    }
}
