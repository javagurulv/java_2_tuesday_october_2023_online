package fitness_club.console_UI;

import fitness_club.core.requests.RemoveClientByPersonalCodeRequest;
import fitness_club.core.responses.RemoveClientByPersonalCodeResponse;
import fitness_club.core.services.RemoveClientByPersonalCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class RemoveClientUIAction implements UIAction {
    @Autowired
    private RemoveClientByPersonalCodeService removeClientByPersonalCodeService;


    @Override
    public void execute() {
      Scanner scanner = new Scanner(System.in);
        System.out.println("Enter client id to remove: ");
        String personalCode = scanner.nextLine();
        RemoveClientByPersonalCodeRequest request = new RemoveClientByPersonalCodeRequest(personalCode);
        RemoveClientByPersonalCodeResponse response =
                removeClientByPersonalCodeService.execute(request);

        if (response.hasErrors()) {
            response.getErrors().forEach(coreError -> System.out.println("Alarm: " + coreError.getField() + " " + coreError.getMessage()));
        } else {
            if (response.isClientRemoved()) {
                System.out.println("Client was removed from list.");
            } else {
                System.out.println("Client was not removed from list.");
            }
        }
    }
}

