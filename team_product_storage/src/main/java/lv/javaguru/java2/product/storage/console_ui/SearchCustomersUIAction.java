package lv.javaguru.java2.product.storage.console_ui;

import lv.javaguru.java2.product.storage.core.requests.Ordering;
import lv.javaguru.java2.product.storage.core.requests.Paging;
import lv.javaguru.java2.product.storage.core.requests.SearchCustomersRequest;
import lv.javaguru.java2.product.storage.core.responses.SearchCustomersResponse;
import lv.javaguru.java2.product.storage.core.services.SearchCustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class SearchCustomersUIAction implements UIAction {

    @Autowired
    private SearchCustomersService searchCustomersService;

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter customer name: ");
        String customerName = scanner.nextLine();
        System.out.println("Enter registration code: ");
        String registrationCode = scanner.nextLine();

        System.out.println("Enter orderBy (customerName||registrationCode): ");
        String orderBy = scanner.nextLine();
        System.out.println("Enter orderDirection (ASCENDING||DESCENDING): ");
        String orderDirection = scanner.nextLine();
        Ordering ordering = new Ordering(orderBy, orderDirection);

        System.out.println("Enter pageNumber: ");
        Integer pageNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter pageSize: ");
        Integer pageSize = Integer.parseInt(scanner.nextLine());
        Paging paging = new Paging(pageNumber, pageSize);

        SearchCustomersRequest request = new SearchCustomersRequest(customerName, registrationCode, ordering, paging);
        SearchCustomersResponse response = searchCustomersService.execute(request);

        if (response.hasErrors()) {
            response.getErrors().forEach(coreError -> System.out.println("Error: " + coreError.getErrorCode() + " " + coreError.getMessage()));
        } else {
            response.getCustomers().forEach(System.out::println);
        }
    }
}
