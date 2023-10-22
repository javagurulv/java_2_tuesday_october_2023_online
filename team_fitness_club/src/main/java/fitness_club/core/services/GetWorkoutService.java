package fitness_club.core.services;
import fitness_club.core.domain.Workouts;

public class GetWorkoutService {

    public static Workouts getWorkout(int id) {
        Workouts selectedWorkout = null;
        switch (id) {
            case 1 -> selectedWorkout = Workouts.GYM;
            case 2 -> selectedWorkout = Workouts.SWIMMING_POOL;
            case 3 -> selectedWorkout = Workouts.GROUP_CLASSES;
            default -> System.out.println("No such workout option");
        }
        return selectedWorkout;
    }
}
