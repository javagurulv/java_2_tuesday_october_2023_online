package lv.javaguru.travel.insurance.ui;

import lv.javaguru.travel.insurance.services.AddBookService;

import java.util.Scanner;

public class AddBookUIAction  implements UIAction {

    private AddBookService service;

    public AddBookUIAction(AddBookService service) {
        this.service = service;
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book title: ");
        String bookTitle = scanner.nextLine();
        System.out.println("Enter book author: ");
        String bookAuthor = scanner.nextLine();

        service.addBook(bookTitle, bookAuthor);

        System.out.println("Your book was added to the list: ");
    }
}

