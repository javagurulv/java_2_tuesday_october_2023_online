package lv.javaguru.travel.insurance.services;

import lv.javaguru.travel.insurance.database.Database;
import lv.javaguru.travel.insurance.domain.Book;

import java.util.List;

public class GetAllBooksService {
    private Database database;

    public GetAllBooksService(Database database) {
        this.database = database;
    }

    public List<Book> getAllBooks() {
        return database.getAllBooks();
    }
}
