package lv.javaguru.travel.insurance.services;

import lv.javaguru.travel.insurance.database.Database;
import lv.javaguru.travel.insurance.domain.Book;

public class AddBookService {

        private Database database;

    public AddBookService(Database database) {
        this.database = database;
    }

        public void addBook(String title, String author) {
        Book book = new Book(title, author);
        database.addBook(book);
    }
}
