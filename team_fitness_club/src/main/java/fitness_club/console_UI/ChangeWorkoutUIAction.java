package fitness_club.console_UI;

import fitness_club.core.database.MemberCardRepository;
import fitness_club.core.domain.Workouts;
import fitness_club.core.requests.ChangeClientWorkoutRequest;
import fitness_club.core.responses.ChangeClientWorkoutResponse;
import fitness_club.core.services.ChangeClientWorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

//@Component
public class ChangeWorkoutUIAction implements UIAction {
   @Autowired
   private ChangeClientWorkoutService service;

   @Autowired
   private MemberCardRepository memberCardRepository;


    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Change client workout: ");
        System.out.println("Enter client Id: ");
        Long clientId = scanner.nextLong();

        System.out.println("Enter Id of workout:  ");
        //printEnumValues(Workouts.values());
        Long newWorkout = Long.parseLong(scanner.nextLine());

        ChangeClientWorkoutRequest request = new ChangeClientWorkoutRequest(clientId, newWorkout);
        ChangeClientWorkoutResponse response = service.execute(request);

        if (response.hasErrors()) {
            response.getErrors().forEach(coreError -> System.out.println("Alarm: " + coreError.getField() + " " + coreError.getMessage()));
        } else {
            if (response.isClientWorkoutsChanged()) {
                System.out.println("Client workout was changed.");
            } else {
                System.out.println("Client workout was not changed.");
            }
        }
    }

    private void printEnumValues(Enum<?>[] values) {
        for (int i = 0; i < values.length; i++) {
            System.out.println((i + 1) + ". " + values[i]);
        }
    }
}
