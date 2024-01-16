package fitness_club.console_UI;

import fitness_club.core.database.MemberCardRepository;
import fitness_club.core.requests.ChangeClientFitnessCenterRequest;
import fitness_club.core.responses.ChangeClientFitnessCenterResponse;
import fitness_club.core.services.ChangeClientFitnessCenterService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

//@Component
public class ChangeClientFitnessCentreUIAction implements UIAction {
    @Autowired
    private ChangeClientFitnessCenterService service;

    @Autowired
    private MemberCardRepository memberCardRepository;

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Change client fitness centre: ");
        System.out.println("Enter client Id: ");
        Long clientId = scanner.nextLong();

        System.out.println("Enter Id of fitness center: ");
        // printEnumValues(FitnessCentres.values());
        Long newFitnessCentre = Long.parseLong(scanner.nextLine());

        ChangeClientFitnessCenterRequest request = new ChangeClientFitnessCenterRequest(clientId, newFitnessCentre);
        ChangeClientFitnessCenterResponse response = service.execute(request);

        if (response.hasErrors()) {
            response.getErrors().forEach(coreError -> System.out.println("Alarm: " + coreError.getField() + " " + coreError.getMessage()));
        } else {
            if (response.isClientFitnessCentreChanged()) {
                System.out.println("Client workout was changed.");
            } else {
                System.out.println("Client workout was not changed.");
            }
        }
    }
}
