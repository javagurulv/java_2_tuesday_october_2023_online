package lessoncode.services;

import lessoncode.database.Database;
import lessoncode.domain.Book;

public class DeleteBookService {

        private Database database;

    public DeleteBookService(Database database) {
        this.database = database;
    }

        public void execute(String title, String author) {
        Book book = new Book(title, author);
        database.deleteBook(book);
    }
}
