package fitness_club.requests;

import fitness_club.domain.Workouts;

public class ChangeWorkoutRequest {

    private String personalCode;
    private Workouts workout;

    public String getPersonalCode() {
        return personalCode;
    }

    public Workouts getWorkout() {
        return workout;
    }

    public ChangeWorkoutRequest(String personalCode, Workouts workout) {
        this.personalCode = personalCode;
        this.workout = workout;
    }
}
