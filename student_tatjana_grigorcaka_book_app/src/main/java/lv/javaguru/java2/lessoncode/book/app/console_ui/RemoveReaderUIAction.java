package lv.javaguru.java2.lessoncode.book.app.console_ui;

import lv.javaguru.java2.lessoncode.book.app.core.requests.RemoveBookRequest;
import lv.javaguru.java2.lessoncode.book.app.core.requests.RemoveReaderRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.RemoveBookResponse;
import lv.javaguru.java2.lessoncode.book.app.core.responses.RemoveReaderResponse;
import lv.javaguru.java2.lessoncode.book.app.core.services.RemoveBookService;
import lv.javaguru.java2.lessoncode.book.app.core.services.RemoveReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class RemoveReaderUIAction implements UIAction {

    @Autowired private RemoveReaderService removeReaderService;

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter reader id to remove: ");
        Long readerId = Long.parseLong(scanner.nextLine());
        RemoveReaderRequest request = new RemoveReaderRequest(readerId);
        RemoveReaderResponse response = removeReaderService.execute(request);

        if (response.containsErrors()) {
            response.getErrors().forEach(businessError -> System.out.println("Error: " + businessError.getErrorCode() + " " + businessError.getErrorMessage()));
        } else {
            if (response.isReaderRemoved()) {
                System.out.println("Your reader was removed from list.");
            } else {
                System.out.println("Your reader not removed from list.");
            }
        }
    }
}
