package lv.javaguru.travel.insurance.consoleUI;

import lv.javaguru.travel.insurance.Book;
import lv.javaguru.travel.insurance.Database;
import lv.javaguru.travel.insurance.InMemoryDatabaseImpl;

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

