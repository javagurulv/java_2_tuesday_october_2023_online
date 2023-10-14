package lv.javaguru.travel.insurance.ui;

import lv.javaguru.travel.insurance.domain.Book;
import lv.javaguru.travel.insurance.services.GetAllBooksService;

public class PrintAllBooksUIAction implements UIAction {

    private GetAllBooksService service;

    public PrintAllBooksUIAction(GetAllBooksService service) {
        this.service = service;
    }

    public void execute() {
        System.out.println("Book list: ");
        for (Book book : service.getAllBooks()) {
            System.out.println(book);
        }
        System.out.println("Book list end.");
    }
}
