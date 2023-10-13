package lv.javaguru.travel.insurance.services;

import lv.javaguru.travel.insurance.database.Database;
import lv.javaguru.travel.insurance.domain.Book;

public class DeleteBookService {

        private Database database;

    public DeleteBookService(Database database) {
        this.database = database;
    }

        public void deleteBook(String title, String author) {
        Book book = new Book(title, author);
        database.deleteBook(book);
    }
}
