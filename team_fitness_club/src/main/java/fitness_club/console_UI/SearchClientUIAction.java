package fitness_club.console_UI;

import fitness_club.core.requests.SearchClientRequest;
import fitness_club.core.responses.SearchClientResponse;
import fitness_club.core.services.SearchClientService;

import java.util.Scanner;

public class SearchClientUIAction implements UIAction {

    private SearchClientService searchClientService;

    public SearchClientUIAction (SearchClientService searchClientService) { this.searchClientService = searchClientService; }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter client first name:");
        String firstName = scanner.nextLine();
        System.out.println("Enter client last name:");
        String lastName = scanner.nextLine();

        SearchClientRequest request = new SearchClientRequest(firstName, lastName);
        SearchClientResponse response = searchClientService.execute(request);

        if (response.hasErrors()) {
            response.getErrors().forEach(coreError -> System.out.println("BL Error: " +coreError.getField() + " " +coreError.getMessage()));
        } else {
            System.out.println("Found Client list:");
            response.getFoundClients().forEach(System.out::println);
            System.out.println("End of found Client list.");
        }
    }
}
