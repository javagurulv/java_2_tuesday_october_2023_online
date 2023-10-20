package lv.javaguru.java2.lessoncode.bookapp.services;

import lv.javaguru.java2.lessoncode.bookapp.database.Database;
import lv.javaguru.java2.lessoncode.bookapp.domain.Book;
import lv.javaguru.java2.lessoncode.bookapp.requests.GetAllBooksRequest;
import lv.javaguru.java2.lessoncode.bookapp.responses.GetAllBooksResponse;

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
