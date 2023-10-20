package lv.javaguru.java2.lessoncode.bookapp.console_ui;

import lv.javaguru.java2.lessoncode.bookapp.core.requests.RemoveBookRequest;
import lv.javaguru.java2.lessoncode.bookapp.core.responses.RemoveBookResponse;
import lv.javaguru.java2.lessoncode.bookapp.core.services.DeleteBookService;

import java.util.Scanner;

public class DeleteBookUIAction implements UIAction {

    private DeleteBookService deleteBookService;

    public DeleteBookUIAction(DeleteBookService deleteBookService) {
        this.deleteBookService = deleteBookService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book id to remove: ");
        Long bookId = Long.parseLong(scanner.nextLine());
        RemoveBookRequest request = new RemoveBookRequest(bookId);
        RemoveBookResponse response = deleteBookService.execute(request);

        if (response.containsErrors()) {
            response.getErrors().forEach(businessError -> System.out.println("Error: " + businessError.getErrorCode() + " " + businessError.getErrorMessage()));
        } else {
            if (response.isBookRemoved()) {
                System.out.println("Your book was removed from list.");
            } else {
                System.out.println("Your book not removed from list.");
            }
        }
    }
}
