package fitness_club.console_UI;

import fitness_club.core.domain.ClientAgeGroups;
import fitness_club.core.domain.Workouts;
import fitness_club.core.requests.AddClientRequest;
import fitness_club.core.responses.ClientResponse;
import fitness_club.core.services.AddClientService;
import fitness_club.core.services.GetClientAgeGroupService;
import fitness_club.core.services.GetWorkoutService;

import java.util.Scanner;

public class AddClientUIAction implements UIAction {
    private AddClientService service;

    public AddClientUIAction(AddClientService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter client first name: ");
        String clientFirstName = scanner.nextLine();
        clientFirstName = (!clientFirstName.isEmpty()) ? clientFirstName.toLowerCase().substring(0, 1).
                toUpperCase().concat(clientFirstName.substring(1)) : clientFirstName;
        System.out.println("Enter client last name: ");
        String clientLastName = scanner.nextLine();
        clientLastName = (!clientLastName.isEmpty()) ? clientLastName.toLowerCase().substring(0, 1).
                toUpperCase().concat(clientLastName.substring(1)) : clientLastName;
        System.out.println("Enter client personal code: ");
        String clientPersonalCode = scanner.nextLine();
        System.out.println("Choose client age group: ");
        System.out.println("1. Child");
        System.out.println("2. Adult");
        System.out.println("3. Senior");
        ClientAgeGroups clientAgeGroups = GetClientAgeGroupService.getClientAgeGroup(Integer.parseInt(scanner.nextLine()));
        System.out.println("Choose client workout.");
        System.out.println("1. GYM");
        System.out.println("2. Swimming Pool");
        System.out.println("3. Group Classes");
        Workouts clientWorkout = GetWorkoutService.getWorkout(Integer.parseInt(scanner.nextLine()));

        AddClientRequest request = new AddClientRequest(clientFirstName, clientLastName, clientPersonalCode, clientAgeGroups, clientWorkout);
        ClientResponse response = service.execute(request);
        if (response.hasErrors()) {
            response.getErrors().forEach(coreError ->
                    System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage())
            );
        } else {
            System.out.println("New client id was: " + response.getNewClient().getId());
            System.out.println("Your client was added to list.");
        }
    }
}
