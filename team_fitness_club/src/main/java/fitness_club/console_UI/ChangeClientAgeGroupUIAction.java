package fitness_club.console_UI;

import fitness_club.core.domain.ClientAgeGroups;
import fitness_club.core.requests.ChangeClientAgeGroupRequest;
import fitness_club.core.responses.AddClientResponse;
import fitness_club.core.responses.ChangeClientAgeGroupResponse;
import fitness_club.core.services.ChangeClientAgeGroupService;
import fitness_club.core.services.GetClientAgeGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.Scanner;

//@Component
abstract public class ChangeClientAgeGroupUIAction implements UIAction {
   /* @Autowired
    private ChangeClientAgeGroupService changeClientAgeGroupService;


    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Change client age group: ");
        System.out.println("Enter client personal code: ");
        String clientPersonalCode = scanner.nextLine();
        System.out.println("Choose new age group.");
        System.out.println("1. Child");
        System.out.println("2. Adult");
        System.out.println("3. Senior");
        ClientAgeGroups newClientAgeGroups = null;
        try {
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                newClientAgeGroups = GetClientAgeGroupService.getClientAgeGroup(Integer.parseInt(input));
            }
        } catch (NumberFormatException e) {
        }

        ChangeClientAgeGroupRequest request = new ChangeClientAgeGroupRequest(clientPersonalCode, newClientAgeGroups);
        ChangeClientAgeGroupResponse response = changeClientAgeGroupService.execute(request);

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

    */
}
