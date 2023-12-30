package lv.javaguru.java2.product.storage.console_ui;

import lv.javaguru.java2.product.storage.core.requests.RegisterCustomerRequest;
import lv.javaguru.java2.product.storage.core.responses.RegisterCustomerResponse;
import lv.javaguru.java2.product.storage.core.services.RegisterCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class RegisterCustomerUIAction implements UIAction {

	@Autowired private RegisterCustomerService registerCustomerService;

	@Override
	public void execute() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter customer name: ");
		String customerName = scanner.nextLine();
		System.out.println("Enter registration code: ");
		String registrationCode = scanner.nextLine();
		RegisterCustomerRequest request = new RegisterCustomerRequest(customerName, registrationCode);
		RegisterCustomerResponse response = registerCustomerService.execute(request);

		if (response.hasErrors()) {
			response.getErrors().forEach(coreError ->
				System.out.println("Error: " + coreError.getErrorCode() + " " + coreError.getMessage())
			);
		} else {
			System.out.println("New reader id was: " + response.getNewCustomer().getId());
			System.out.println("Reader was added to list.");
		}
	}

}