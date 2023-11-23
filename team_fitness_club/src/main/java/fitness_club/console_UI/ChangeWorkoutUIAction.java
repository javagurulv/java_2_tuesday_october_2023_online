package fitness_club.console_UI;

import fitness_club.core.domain.Workouts;
import fitness_club.core.requests.ChangeClientWorkoutsRequest;
import fitness_club.core.responses.ChangeClientWorkoutsResponse;
import fitness_club.core.services.ChangeClientWorkoutService;
import fitness_club.core.services.GetWorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ChangeWorkoutUIAction implements UIAction {
   @Autowired
   private ChangeClientWorkoutService service;


    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Change client workout: ");
        System.out.println("Enter client personal code: ");
        String clientPersonalCode = scanner.nextLine();
        System.out.println("Choose new workout.");
        System.out.println("1. GYM");
        System.out.println("2. Swimming Pool");
        System.out.println("3. Group Classes");
        Workouts newWorkout = null;
        try {
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                newWorkout = GetWorkoutService.getWorkout(Integer.parseInt(input));
            }
        } catch (NumberFormatException e) {
        }

        ChangeClientWorkoutsRequest request = new ChangeClientWorkoutsRequest(clientPersonalCode, newWorkout);
        ChangeClientWorkoutsResponse response = service.execute(request);
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
}
