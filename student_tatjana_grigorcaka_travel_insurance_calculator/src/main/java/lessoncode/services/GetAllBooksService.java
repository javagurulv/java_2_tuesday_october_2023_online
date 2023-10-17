package lessoncode.services;

import lessoncode.database.Database;
import lessoncode.domain.Book;

import java.util.List;

public class GetAllBooksService {
    private Database database;

    public GetAllBooksService(Database database) {
        this.database = database;
    }

    public List<Book> execute() {
        return database.getAllBooks();
    }
}
