package lv.javaguru.java2.lessoncode.bookapp.core.services;

import lv.javaguru.java2.lessoncode.bookapp.core.database.Database;
import lv.javaguru.java2.lessoncode.bookapp.core.domain.Book;
import lv.javaguru.java2.lessoncode.bookapp.core.requests.GetAllBooksRequest;
import lv.javaguru.java2.lessoncode.bookapp.core.responses.GetAllBooksResponse;

import java.util.List;

public class GetAllBooksService {
    private Database database;

    public GetAllBooksService(Database database) {
        this.database = database;
    }

    public GetAllBooksResponse execute(GetAllBooksRequest request) {
        List<Book> books = database.getAllBooks();
        return new GetAllBooksResponse(books);
    }
}
