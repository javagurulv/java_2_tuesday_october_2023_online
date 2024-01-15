package fitness_club.console_UI;

import fitness_club.core.database.MemberCardRepository;
import fitness_club.core.requests.ChangeClientAgeGroupRequest;
import fitness_club.core.responses.ChangeClientAgeGroupResponse;
import fitness_club.core.services.ChangeClientAgeGroupService;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Scanner;

//@Component
public class ChangeClientAgeGroupUIAction implements UIAction {
    @Autowired
    private ChangeClientAgeGroupService service;

    @Autowired private MemberCardRepository memberCardRepository;


    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Change client age group: ");
        System.out.println("Enter client ID number: ");
        Long clientId = scanner.nextLong();

        System.out.println("Enter Id of age group: ");
       // printEnumValues(AgeGroups.values());
        Long newClientAgeGroup = Long.parseLong(scanner.nextLine());

        ChangeClientAgeGroupRequest request = new ChangeClientAgeGroupRequest(clientId, newClientAgeGroup);
        ChangeClientAgeGroupResponse response = service.execute(request);

        if (response.hasErrors()) {
            response.getErrors().forEach(coreError -> System.out.println("Alarm: " + coreError.getField() + " " + coreError.getMessage()));
        } else {
            if (response.isClientAgeGroupChanged()) {
                System.out.println("Client age group was changed.");
            } else {
                System.out.println("Client age group was not changed.");
            }
        }
    }

    private void printEnumValues(Enum<?>[] values) {
        for (int i = 0; i < values.length; i++) {
            System.out.println((i + 1) + ". " + values[i]);
        }
    }
}
