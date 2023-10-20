package fitness_club.console_UI;

import fitness_club.domain.ClientAgeGroups;
import fitness_club.services.ChangeClientAgeGroupService;
import fitness_club.services.GetClientAgeGroupService;


import java.util.Scanner;

public class ChangeClientAgeGrpoupUIAction implements UIAction {
    private ChangeClientAgeGroupService service;

    public ChangeClientAgeGrpoupUIAction(ChangeClientAgeGroupService service) {
        this.service = service;
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
        GetClientAgeGroupService getClientAgeGroupService = new GetClientAgeGroupService();
        ClientAgeGroups newClientAgeGroups = getClientAgeGroupService.getClientAgeGroup(Integer.parseInt(scanner.nextLine()));


        service.changeClientAgeGroup(clientPersonalCode,newClientAgeGroups);

        System.out.println("Client workout has been changed.");
    }
}
