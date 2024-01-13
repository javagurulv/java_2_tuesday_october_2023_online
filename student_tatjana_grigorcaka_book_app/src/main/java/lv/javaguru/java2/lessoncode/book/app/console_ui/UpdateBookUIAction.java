package lv.javaguru.java2.lessoncode.book.app.console_ui;

import lv.javaguru.java2.lessoncode.book.app.core.requests.UpdateBookRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.UpdateBookResponse;
import lv.javaguru.java2.lessoncode.book.app.core.services.UpdateBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class UpdateBookUIAction implements UIAction {

    @Autowired private UpdateBookService updateBookService;


    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter book id to update: ");
        Long bookId = Long.parseLong(scanner.nextLine());
        System.out.println("Enter new book title: ");
        String newTitle = scanner.nextLine();
        System.out.println("Enter new book author: ");
        String newAuthor = scanner.nextLine();
        System.out.println("Enter new issue year: ");
        Integer newIssueYear = scanner.nextInt();
        UpdateBookRequest request = new UpdateBookRequest(bookId, newTitle, newAuthor, newIssueYear);
        UpdateBookResponse response = updateBookService.execute(request);

        if (response.containsErrors()) {
            response.getErrors().forEach(coreError ->
                    System.out.println("Error: " + coreError.getErrorCode() + " " + coreError.getErrorMessage())
            );
        } else {
            System.out.println("Your book was updated" + response.getUpdatedBook());

        }
    }
}
