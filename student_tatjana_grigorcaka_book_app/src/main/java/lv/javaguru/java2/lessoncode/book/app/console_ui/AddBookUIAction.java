package lv.javaguru.java2.lessoncode.book.app.console_ui;

import lv.javaguru.java2.lessoncode.book.app.core.responses.CoreError;
import lv.javaguru.java2.lessoncode.book.app.core.services.AddBookService;
import lv.javaguru.java2.lessoncode.book.app.core.requests.AddBookRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.AddBookResponse;
import lv.javaguru.java2.lessoncode.book.app.dependency_injection.DIComponent;
import lv.javaguru.java2.lessoncode.book.app.dependency_injection.DIDependency;

import java.util.Scanner;

@DIComponent
public class AddBookUIAction  implements UIAction {

    @DIDependency private AddBookService addBookService;

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book title: ");
        String bookTitle = scanner.nextLine();
        System.out.println("Enter book author: ");
        String bookAuthor = scanner.nextLine();
        AddBookRequest request = new AddBookRequest(bookAuthor, bookTitle);
        AddBookResponse response = addBookService.execute(request);

        if (response.containsErrors()) {
            for (CoreError error : response.getErrors()) {
                System.out.println("Error: " + error.getErrorCode() + " " + error.getErrorMessage());
            }
        } else {
            System.out.println("New book id was: " + response.getNewBook().getId());
            System.out.println("Your book was added to the list: ");
        }
    }
}

