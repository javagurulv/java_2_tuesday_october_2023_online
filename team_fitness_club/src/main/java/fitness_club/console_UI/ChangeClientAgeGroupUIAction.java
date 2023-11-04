package fitness_club.console_UI;

import fitness_club.core.domain.ClientAgeGroups;
import fitness_club.core.requests.ChangeClientAgeGroupRequest;
import fitness_club.core.responses.AddClientResponse;
import fitness_club.core.responses.ChangeClientAgeGroupResponse;
import fitness_club.core.services.ChangeClientAgeGroupService;
import fitness_club.core.services.GetClientAgeGroupService;


import java.util.Scanner;

public class ChangeClientAgeGroupUIAction implements UIAction {
    private ChangeClientAgeGroupService changeClientAgeGroupService;

    public ChangeClientAgeGroupUIAction(ChangeClientAgeGroupService changeClientAgeGroupService) {
        this.changeClientAgeGroupService = changeClientAgeGroupService;
    }

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
        ClientAgeGroups newClientAgeGroups = GetClientAgeGroupService.getClientAgeGroup(Integer.parseInt(scanner.nextLine()));

        ChangeClientAgeGroupRequest request = new ChangeClientAgeGroupRequest(clientPersonalCode, newClientAgeGroups);
        ChangeClientAgeGroupResponse response = changeClientAgeGroupService.execute(request);

        System.out.println("Client age group has been changed.");
    }
}
