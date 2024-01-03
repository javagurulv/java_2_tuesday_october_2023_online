package fitness_club.console_UI;

import fitness_club.core.domain.FitnessCentres;
import fitness_club.core.requests.ChangeClientFitnessCentreRequest;
import fitness_club.core.responses.ChangeClientFitnessCentreResponse;
import fitness_club.core.services.ChangeClientFitnessCentreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;
//@Component
public class ChangeClientFitnessCentreUIAction implements UIAction {
    @Autowired
    private ChangeClientFitnessCentreService service;

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Change client fitness centre: ");
        System.out.println("Enter client personal code: ");
        String clientPersonalCode = scanner.nextLine();

        System.out.println("Choose new fitness centre.");
       // printEnumValues(FitnessCentres.values());
        Long newFitnessCentre = Long.parseLong(scanner.nextLine());

        ChangeClientFitnessCentreRequest request = new ChangeClientFitnessCentreRequest(clientPersonalCode, newFitnessCentre);
        ChangeClientFitnessCentreResponse response = service.execute(request);

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

    private void printEnumValues(Enum<?>[] values) {
        for (int i = 0; i < values.length; i++) {
            System.out.println((i + 1) + ". " + values[i]);
        }
    }
}
