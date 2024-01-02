package fitness_club.console_UI;

import fitness_club.core.database.AgeGroupsRepository;
import fitness_club.core.database.ClientRepository;
import fitness_club.core.database.WorkoutsRepository;
import fitness_club.core.domain.FitnessCentres;
import fitness_club.core.requests.FindUniqueClientRequest;
import fitness_club.core.requests.GetClientAgeGroupRequest;
import fitness_club.core.responses.FindUniqueClientResponse;
import fitness_club.core.responses.GetClientAgeGroupResponse;
import fitness_club.core.services.AddMemberCardService;
import fitness_club.core.services.FindUniqueClientService;
import fitness_club.core.services.GetClientAgeGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

@Component
public class CreateMemberCardUIAction implements UIAction {

    @Autowired
    private AddMemberCardService addMemberCardService;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AgeGroupsRepository ageGroupsRepository;

    @Autowired
    private WorkoutsRepository workoutsRepository;

    @Autowired
    private FitnessCentres fitnessCentres;

    @Autowired
    private FindUniqueClientService findUniqueClientService;

    @Autowired
    private GetClientAgeGroupService getClientAgeGroupService;


    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter client personal code: ");
        String clientPersonalCode = scanner.nextLine();
        FindUniqueClientRequest uniqueClientRequest = new FindUniqueClientRequest(clientPersonalCode);
        FindUniqueClientResponse uniqueClientResponse = findUniqueClientService.execute(uniqueClientRequest);

        if (uniqueClientResponse.hasErrors()) {
            uniqueClientResponse.getErrors().forEach(coreError -> System.out.println("Alarm: " + coreError.getField() + " " + coreError.getMessage()));
        } else {
            if (uniqueClientResponse.isClientFound()) {

                System.out.println("Client is found.");
                System.out.println("Choose client age group: ");
                GetClientAgeGroupRequest ageGroupRequest = new GetClientAgeGroupRequest();
                GetClientAgeGroupResponse ageGroupResponse = getClientAgeGroupService.execute(ageGroupRequest);
                ageGroupResponse.getAgeGroups();

            } else {
                System.out.println("Client is not found!");
            }
        }
        System.out.println("Choose client age group ID: ");

        GetClientAgeGroupRequest ageGroupRequest = new GetClientAgeGroupRequest();
        GetClientAgeGroupResponse ageGroupResponse = getClientAgeGroupService.execute(ageGroupRequest);
        ageGroupResponse.getAgeGroups();
        //printEnumValues(AgeGroups.values());
        //String clientAgeGroup = String.valueOf(AgeGroups.values()[Integer.parseInt(scanner.nextLine())]);

        System.out.println("Choose client workout: ");
        // printEnumValues(Workouts.values());
        // String clientWorkout = String.valueOf(Workouts.values()[Integer.parseInt(scanner.nextLine())]);

        System.out.println("Choose new fitness centre: ");
        //printEnumValues(FitnessCentres.values());
        // String fitnessCentre = String.valueOf(FitnessCentres.values()[Integer.parseInt(scanner.nextLine())]);

        System.out.println("Choose the date contract ends in format YYYY-MM-DD: ");
        Date termOfContract = parseDate(scanner.nextLine());

        // AddMemberCardRequest request = new AddMemberCardRequest(clientRepository.findByPersonalCode(clientPersonalCode).get(0), clientAgeGroup, clientWorkout, fitnessCentre, termOfContract);
        // AddMemberCardsResponse response = service.execute(request);

        // if (response.hasErrors()) {
        //  response.getErrors().forEach(coreError ->
        //                System.out.println("Oshibka: " + coreError.getField() + " " + coreError.getMessage())
        //        );
        //   } else {
        //       System.out.println("Client has a member card now! Member Card ID: " + response.getNewMemberCard().getClient().getId());
        //     System.out.println("Enjoy your fitness.");
        // }
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