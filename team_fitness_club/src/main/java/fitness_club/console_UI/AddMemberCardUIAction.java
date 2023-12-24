package fitness_club.console_UI;

import fitness_club.core.domain.ClientAgeGroups;
import fitness_club.core.domain.FitnessCentre;
import fitness_club.core.domain.Workouts;
import fitness_club.core.requests.AddMemberCardRequest;
import fitness_club.core.responses.AddMemberCardsResponse;
import fitness_club.core.services.AddMemberCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

@Component
public class AddMemberCardUIAction implements UIAction {

    @Autowired
    private AddMemberCardService service;

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter existing client personal code: ");
        String clientPersonalCode = scanner.nextLine();

        System.out.println("Choose client age group: ");
        printEnumValues(ClientAgeGroups.values());
        Long clientAgeGroup = Long.parseLong(scanner.nextLine());

        System.out.println("Choose client workout: ");
        printEnumValues(Workouts.values());
        Long clientWorkout = Long.parseLong(scanner.nextLine());

        System.out.println("Choose new fitness centre: ");
        printEnumValues(FitnessCentre.values());
        Long fitnessCentre = Long.parseLong(scanner.nextLine());

        System.out.println("Choose the date contract ends in format YYYY-MM-DD: ");
        Date termOfContract = parseDate(scanner.nextLine());

        AddMemberCardRequest request = new AddMemberCardRequest(clientPersonalCode, clientAgeGroup, clientWorkout, fitnessCentre, termOfContract);
        AddMemberCardsResponse response = service.execute(request);

        if (response.hasErrors()) {
            response.getErrors().forEach(coreError ->
                    System.out.println("Oshibka: " + coreError.getField() + " " + coreError.getMessage())
            );
        } else {
            System.out.println("Client has a member card now! Member Card ID: " + response.getNewMemberCard().getClientId());
            System.out.println("Enjoy your fitness.");
        }
    }

    private void printEnumValues(Enum<?>[] values) {
        for (int i = 0; i < values.length; i++) {
            System.out.println((i + 1) + ". " + values[i]);
        }
    }

    private Date parseDate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format. Please use YYYY-MM-DD.", e);
        }
    }
}
