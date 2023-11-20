package fitness_club.console_UI;

import fitness_club.core.requests.Ordering;
import fitness_club.core.requests.Paging;
import fitness_club.core.requests.SearchClientRequest;
import fitness_club.core.responses.SearchClientResponse;
import fitness_club.core.services.SearchClientService;
import fitness_club.dependency_injection.DIComponent;
import fitness_club.dependency_injection.DIDependency;

import java.util.Scanner;

@DIComponent
public class SearchClientUIAction implements UIAction {

    @DIDependency private SearchClientService searchClientService;



    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter client first name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter client last name:");
        String lastName = scanner.nextLine();
        System.out.println();

        System.out.println("Enter orderBy client firstName or lastName): ");
        String orderBy = scanner.nextLine();
        System.out.println("Enter orderDirection (ASCENDING||DESCENDING): ");
        String orderDirection = scanner.nextLine();
        Ordering ordering = new Ordering(orderBy, orderDirection);

        System.out.println("Enter pageNumber: ");
        Integer pageNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter pageSize: ");
        Integer pageSize = Integer.parseInt(scanner.nextLine());
        Paging paging = new Paging(pageNumber, pageSize);

        SearchClientRequest request = new SearchClientRequest(firstName, lastName, ordering, paging);
        SearchClientResponse response = searchClientService.execute(request);

        if (response.hasErrors()) {
            response.getErrors().forEach(coreError -> System.out.println("BL Error: " + coreError.getField() + " " + coreError.getMessage()));
        } else {
            response.getFoundClients().forEach(System.out::println);
        }
    }
}
