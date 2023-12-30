package fitness_club.console_UI;

import fitness_club.core.requests.AddClientRequest;
import fitness_club.core.responses.AddClientResponse;
import fitness_club.core.services.AddClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AddClientUIAction implements UIAction {
    @Autowired
    private AddClientService service;


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
        /*System.out.println("Choose client age group: ");
        System.out.println("1. Child");
        System.out.println("2. Adult");
        System.out.println("3. Senior");
        ClientAgeGroups clientAgeGroups = GetClientAgeGroupService.getClientAgeGroup(Integer.parseInt(scanner.nextLine()));
        System.out.println("Choose client workout.");
        System.out.println("1. GYM");
        System.out.println("2. Swimming Pool");
        System.out.println("3. Group Classes");
        Workouts clientWorkout = GetWorkoutService.getWorkout(Integer.parseInt(scanner.nextLine()));
        System.out.println("Choose new fitness centre.");
        System.out.println("1. Akropole Riga");
        System.out.println("2. Imanta");
        System.out.println("3. Riga Plaza");
        System.out.println("4. Saga");
        System.out.println("5. Zolitude");
        FitnessCentre fitnessCentre = GetFitnessCentreService.getFitnessCentre(Integer.parseInt(scanner.nextLine()));


         */
        AddClientRequest request = new AddClientRequest(clientFirstName, clientLastName, clientPersonalCode);
        AddClientResponse response = service.execute(request);
        if (response.hasErrors()) {
            response.getErrors().forEach(coreError ->
                    System.out.println("Oshibka: " + coreError.getField() + " " + coreError.getMessage())
            );
        } else {
            System.out.println("New client id was: " + response.getNewClient().getId());
            System.out.println("Your client was added to list.");
        }
    }
}
