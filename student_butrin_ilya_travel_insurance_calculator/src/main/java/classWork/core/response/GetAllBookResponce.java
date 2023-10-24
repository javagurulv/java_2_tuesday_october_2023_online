package classWork.core.response;

import classWork.Book;
import classWork.core.CoreResponse;

import java.util.List;

public class GetAllBookResponce extends CoreResponse {
    List<Book> allbooks;

    public List<Book> getAllbooks() {
        return allbooks;
    }

    public GetAllBookResponce(List<Book> allbooks) {
        this.allbooks = allbooks;
    }
}
