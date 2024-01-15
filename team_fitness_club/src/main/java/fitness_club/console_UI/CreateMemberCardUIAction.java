package fitness_club.console_UI;

import fitness_club.core.database.AdminData;
import fitness_club.core.requests.AddMemberCardRequest;
import fitness_club.core.responses.AddMemberCardResponse;
import fitness_club.core.services.AddMemberCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

@Component
public class CreateMemberCardUIAction implements UIAction {

    @Autowired
    private AdminData adminData;

    @Autowired
    private AddMemberCardService service;


    @Override
    public void execute() {
        System.out.println("Enter client personal code: ");
        Scanner scanner = new Scanner(System.in);
        String clientPersonalCode = scanner.nextLine();

        System.out.println("Enter client ID number: ");
        Scanner scanner2 = new Scanner(System.in);
        Long client = scanner2.nextLong();

        System.out.println(adminData.getAllAgeGroups().toString());
        System.out.println("Enter ID of age group: ");
        Long ageGroup = scanner2.nextLong();

        System.out.println(adminData.getAllWorkouts());
        System.out.println("Enter ID of workout: ");
        Long workout = scanner2.nextLong();

        System.out.println(adminData.getAllFitnessCenters());
        System.out.println("Enter ID of fitness center: ");
        Long fitnessCenter = scanner2.nextLong();

        System.out.println("Enter a contract date (in format YYYY-MM-DD): ");
        Date termOfContract = parseDate(scanner.nextLine());

        AddMemberCardRequest addMemberCardRequest = new AddMemberCardRequest(client, ageGroup,
                workout, fitnessCenter, termOfContract);
        AddMemberCardResponse response = service.execute(addMemberCardRequest);

        if (response.hasErrors()) {
            response.getErrors().forEach(coreError ->
                    System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage())
            );
            System.out.println("Member card not saved!");
        } else {
            System.out.println("Client has a member card now! Member Card ID: " + response.getNewMemberCard().getId());
            System.out.println("Enjoy your fitness.");
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