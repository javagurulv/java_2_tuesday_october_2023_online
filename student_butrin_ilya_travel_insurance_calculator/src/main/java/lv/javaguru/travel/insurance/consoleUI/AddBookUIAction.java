package lv.javaguru.travel.insurance.consoleUI;

import lv.javaguru.travel.insurance.Book;
import lv.javaguru.travel.insurance.Database;
import lv.javaguru.travel.insurance.InMemoryDatabaseImpl;

import java.util.Scanner;

public class AddBookUIAction implements UIAction {
    Database data = new InMemoryDatabaseImpl();

    public AddBookUIAction(Database data) {
        this.data = data;
    }

    @Override
    public void execute() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите автора");
        String author = scan.nextLine();
        System.out.println("Введите название книги");
        String title = scan.nextLine();
        Book book = new Book(author, title);
        data.addBook(book);
    }
}
