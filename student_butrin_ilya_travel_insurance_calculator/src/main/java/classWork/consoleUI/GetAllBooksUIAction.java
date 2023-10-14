package classWork.consoleUI;


import classWork.Database;
import classWork.Book;
import classWork.InMemoryDatabaseImpl;

import java.util.List;

public class GetAllBooksUIAction implements UIAction {
    Database data = new InMemoryDatabaseImpl();

    public GetAllBooksUIAction(Database data) {
        this.data = data;
    }

    @Override
    public void execute() {
        List<Book> books = data.getBooks();
        for (Book bookFromList : books)
            System.out.println(bookFromList.getId() +
                    ". " + bookFromList.getAuthor() +
                    "  " + bookFromList.getTitle());
    }
}

