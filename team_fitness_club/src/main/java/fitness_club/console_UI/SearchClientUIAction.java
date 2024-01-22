package fitness_club.console_UI;

import fitness_club.core.domain.Client;
import fitness_club.core.requests.Ordering;
import fitness_club.core.requests.Paging;
import fitness_club.core.requests.SearchClientsRequest;
import fitness_club.core.responses.SearchClientsResponse;
import fitness_club.core.services.SearchClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class SearchClientUIAction implements UIAction {

    @Autowired
    private SearchClientsService searchClientService;

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter client first name: ");
        String firstName = scanner.nextLine();
        System.out.println("Enter client last name: ");
        String lastName = scanner.nextLine();
        System.out.println("Enter client personal code: ");
        String personalCode = scanner.nextLine();
        System.out.println();

        System.out.println("Enter orderBy client firstName || lastName): ");
        String orderBy = scanner.nextLine();
        System.out.println("Enter orderDirection (ASCENDING||DESCENDING): ");
        String orderDirection = scanner.nextLine();
        Ordering ordering = new Ordering(orderBy, orderDirection);

        System.out.println("Enter pageNumber: ");
        Integer pageNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter pageSize: ");
        Integer pageSize = Integer.parseInt(scanner.nextLine());
        Paging paging = new Paging(pageNumber, pageSize);

        SearchClientsRequest request = new SearchClientsRequest(firstName, lastName, personalCode, ordering, paging);
        SearchClientsResponse response = searchClientService.execute(request);

        if (response.hasErrors()) {
            response.getErrors().forEach(coreError -> System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage()));
        } else {
            response.getFoundClients().forEach(Client::toString);
        }
    }
}
