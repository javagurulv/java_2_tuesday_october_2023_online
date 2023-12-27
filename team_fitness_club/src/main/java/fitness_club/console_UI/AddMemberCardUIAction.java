package fitness_club.console_UI;

import com.mysql.cj.xdevapi.Client;
import fitness_club.core.database.ClientRepository;
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

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter existing client personal code: ");
        String clientPersonalCode = scanner.nextLine();

        System.out.println("Choose client age group: ");
        printEnumValues(ClientAgeGroups.values());
        String clientAgeGroup = scanner.nextLine();

        System.out.println("Choose client workout: ");
        printEnumValues(Workouts.values());
        String clientWorkout = scanner.nextLine();

        System.out.println("Choose new fitness centre: ");
        printEnumValues(FitnessCentre.values());
        String fitnessCentre = scanner.nextLine();

        System.out.println("Choose the date contract ends in format YYYY-MM-DD: ");
        Date termOfContract = parseDate(scanner.nextLine());

        AddMemberCardRequest request = new AddMemberCardRequest(clientRepository.findByPersonalCode(clientPersonalCode).get(0), clientAgeGroup, clientWorkout, fitnessCentre, termOfContract);
        AddMemberCardsResponse response = service.execute(request);

        if (response.hasErrors()) {
            response.getErrors().forEach(coreError ->
                    System.out.println("Oshibka: " + coreError.getField() + " " + coreError.getMessage())
            );
        } else {
            System.out.println("Client has a member card now! Member Card ID: " + response.getNewMemberCard().getClient().getId());
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
