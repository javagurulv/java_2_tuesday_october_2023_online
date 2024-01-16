package lv.javaguru.java2.lessoncode.book.app.console_ui;

import lv.javaguru.java2.lessoncode.book.app.core.requests.UpdateReaderRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.UpdateReaderResponse;
import lv.javaguru.java2.lessoncode.book.app.core.services.UpdateReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class UpdateReaderUIAction implements UIAction {

    @Autowired private UpdateReaderService updateReaderService;


    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter reader id to update: ");
        Long readerId = Long.parseLong(scanner.nextLine());
        System.out.println("Enter new first name: ");
        String newFirstName = scanner.nextLine();
        System.out.println("Enter new last name: ");
        String newLastName = scanner.nextLine();
        System.out.println("Enter new personal code: ");
        String newPersonalCode = scanner.nextLine();
        UpdateReaderRequest request = new UpdateReaderRequest(readerId, newFirstName, newLastName, newPersonalCode);
        UpdateReaderResponse response = updateReaderService.execute(request);

        if (response.containsErrors()) {
            response.getErrors().forEach(coreError ->
                    System.out.println("Error: " + coreError.getErrorCode() + " " + coreError.getErrorMessage())
            );
        } else {
            System.out.println("Your reader was updated" + response.getUpdatedReader());

        }
    }
}
