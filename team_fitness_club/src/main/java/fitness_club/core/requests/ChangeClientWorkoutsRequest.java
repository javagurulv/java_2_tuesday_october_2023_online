package fitness_club.core.requests;

import fitness_club.core.domain.Workouts;

public class ChangeClientWorkoutsRequest {

    private String personalCode;
    private Workouts workout;

    public String getPersonalCode() {
        return personalCode;
    }

    public Workouts getWorkout() {
        return workout;
    }

    public ChangeClientWorkoutsRequest(String personalCode, Workouts workout) {
        this.personalCode = personalCode;
        this.workout = workout;
    }
}
