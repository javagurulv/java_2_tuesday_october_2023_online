package lv.javaguru.java2.lessoncode.book.app.console_ui;

import lv.javaguru.java2.lessoncode.book.app.core.requests.RemoveBookRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.RemoveBookResponse;
import lv.javaguru.java2.lessoncode.book.app.core.services.RemoveBookService;

import java.util.Scanner;

public class RemoveBookUIAction implements UIAction {

    private RemoveBookService removeBookService;

    public RemoveBookUIAction(RemoveBookService removeBookService) {
        this.removeBookService = removeBookService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book id to remove: ");
        Long bookId = Long.parseLong(scanner.nextLine());
        RemoveBookRequest request = new RemoveBookRequest(bookId);
        RemoveBookResponse response = removeBookService.execute(request);

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
