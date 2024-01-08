package classWork.core.response;

import classWork.domen.Book;
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
