package fitness_club.console_UI;

import fitness_club.core.requests.DeleteClientByPersonalCodeRequest;
import fitness_club.core.responses.DeleteClientByPersonalCodeResponse;
import fitness_club.core.services.DeleteClientByPersonalCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

//@Component
public class DeleteClientUIAction implements UIAction {
    @Autowired
    private DeleteClientByPersonalCodeService deleteClientByPersonalCodeService;


    @Override
    public void execute() {
      /* Scanner scanner = new Scanner(System.in);
        System.out.println("Enter client personal code: ");
        String clientPersonalCode = scanner.nextLine();
        DeleteClientByPersonalCodeRequest request = new DeleteClientByPersonalCodeRequest(clientPersonalCode);
        DeleteClientByPersonalCodeResponse response =
                deleteClientByPersonalCodeService.executeByPersonalCode(request);

        if (response.hasErrors()) {
            response.getErrors().forEach(coreError -> System.out.println("Alarm: " + coreError.getField() + " " + coreError.getMessage()));
        } else {
            if (response.isClientRemoved()) {
                System.out.println("Client was deleted from list.");
            } else {
                System.out.println("Client was not deleted from list.");
            }
        }

       */
    }
}

