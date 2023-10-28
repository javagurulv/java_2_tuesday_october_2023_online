package classWork;

import classWork.core.CoreError;

import java.util.ArrayList;
import java.util.List;

public class SearchBooksService {
    SearchBookValigator valigator;
    Database data;

    public SearchBooksService(SearchBookValigator valigator, Database data) {
        this.valigator = valigator;
        this.data = data;
    }
    public SearchBooksResponse searchBook (SearchBooksRequest request) {
        List<CoreError> errorList = valigator.errorList(request);
        List<Book>responceList;
        if (!errorList.isEmpty())
            return new SearchBooksResponse(errorList,null);
        else if (request.getTitle().isEmpty()&&!request.getAuthor().isEmpty()){
            responceList = data.searchByAuthor(request.getAuthor());
        }
        else if (!request.getTitle().isEmpty()&&request.getAuthor().isEmpty()) {
            responceList = data.searchByTitle(request.getTitle());
        }
        else responceList = data.searchByAithorandTitle(request.getAuthor(), request.getTitle());
        return new SearchBooksResponse(responceList);


    }
}
