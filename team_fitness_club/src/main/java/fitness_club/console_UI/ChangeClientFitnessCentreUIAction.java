package fitness_club.console_UI;

import fitness_club.core.domain.FitnessCentre;
import fitness_club.core.requests.ChangeClientFitnessCentreRequest;
import fitness_club.core.responses.ChangeClientFitnessCentreResponse;
import fitness_club.core.services.ChangeClientFitnessCentreService;
import fitness_club.core.services.GetFitnessCentreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component
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
        System.out.println("1. Akropole Riga");
        System.out.println("2. Imanta");
        System.out.println("3. Riga Plaza");
        System.out.println("4. Saga");
        System.out.println("5. Zolitude");
        FitnessCentre newFitnessCentre = null;
        try {
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                newFitnessCentre = GetFitnessCentreService.getFitnessCentre(Integer.parseInt(input));
            }
        } catch (NumberFormatException e) {
        }

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
}
