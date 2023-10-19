package fitness_club.console_UI;

import fitness_club.domain.Workouts;
import fitness_club.requests.ChangeWorkoutRequest;
import fitness_club.responses.AddClientResponse;
import fitness_club.services.ChangeClientWorkoutService;
import fitness_club.services.GetWorkoutService;

import java.util.Scanner;

public class ChangeWorkoutUIAction implements UIAction {
    private ChangeClientWorkoutService service;

    public ChangeWorkoutUIAction(ChangeClientWorkoutService service) {
        this.service = service;
    }

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
        Workouts newWorkout = GetWorkoutService.getWorkout(Integer.parseInt(scanner.nextLine()));

        ChangeWorkoutRequest request = new ChangeWorkoutRequest(clientPersonalCode, newWorkout);
        AddClientResponse response = service.execute(request);

        System.out.println("Client workout has been changed.");
    }
}
