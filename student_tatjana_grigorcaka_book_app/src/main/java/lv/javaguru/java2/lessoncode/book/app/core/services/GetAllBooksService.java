package lv.javaguru.java2.lessoncode.book.app.core.services;

import lv.javaguru.java2.lessoncode.book.app.core.database.Database;
import lv.javaguru.java2.lessoncode.book.app.core.domain.Book;
import lv.javaguru.java2.lessoncode.book.app.core.requests.GetAllBooksRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.GetAllBooksResponse;
import lv.javaguru.java2.lessoncode.book.app.dependency_injection.DIComponent;
import lv.javaguru.java2.lessoncode.book.app.dependency_injection.DIDependency;

import java.util.List;

@DIComponent
public class GetAllBooksService {
    @DIDependency private Database database;

    public GetAllBooksResponse execute(GetAllBooksRequest request) {
        List<Book> books = database.getAllBooks();
        return new GetAllBooksResponse(books);
    }
}
