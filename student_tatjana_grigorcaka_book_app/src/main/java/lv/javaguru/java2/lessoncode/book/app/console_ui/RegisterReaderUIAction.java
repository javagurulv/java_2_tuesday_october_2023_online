package lv.javaguru.java2.lessoncode.book.app.console_ui;

import lv.javaguru.java2.lessoncode.book.app.core.requests.RegisterReaderRequest;
import lv.javaguru.java2.lessoncode.book.app.core.responses.RegisterReaderResponse;
import lv.javaguru.java2.lessoncode.book.app.core.services.RegisterReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class RegisterReaderUIAction implements UIAction {

	@Autowired private RegisterReaderService registerReaderService;

	@Override
	public void execute() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter reader first name: ");
		String readerFirstName = scanner.nextLine();
		System.out.println("Enter reader last name: ");
		String readerLastName = scanner.nextLine();
		System.out.println("Enter reader personal code: ");
		String readerPersonalCode = scanner.nextLine();
		RegisterReaderRequest request = new RegisterReaderRequest(readerFirstName, readerLastName, readerPersonalCode);
		RegisterReaderResponse response = registerReaderService.execute(request);

		if (response.containsErrors()) {
			response.getErrors().forEach(coreError ->
				System.out.println("Error: " + coreError.getErrorCode() + " " + coreError.getErrorMessage())
			);
		} else {
			System.out.println("New reader id was: " + response.getNewReader().getId());
			System.out.println("Reader was added to list.");
		}
	}

}