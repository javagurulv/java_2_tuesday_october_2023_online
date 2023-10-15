package lessoncode.services;

import lessoncode.database.Database;
import lessoncode.domain.Book;

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
