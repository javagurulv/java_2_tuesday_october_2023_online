package lv.javaguru.travel.insurance.ui;

import lv.javaguru.travel.insurance.services.DeleteBookService;

import java.util.Scanner;

public class DeleteBookUIAction implements UIAction {

    private DeleteBookService service;

    public DeleteBookUIAction(DeleteBookService service) {
        this.service = service;
    }

    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book title: ");
        String bookTitle = scanner.nextLine();
        System.out.println("Enter book author: ");
        String bookAuthor = scanner.nextLine();


        service.deleteBook(bookTitle, bookAuthor);

        System.out.println("Your book was deleted from the list: ");


    }
}
