package fitness_club.core.requests;

public class ChangeClientWorkoutRequest {

    private String personalCode;
    private Long workout;

    public String getPersonalCode() {
        return personalCode;
    }

    public Long getWorkout() {
        return workout;
    }

    public ChangeClientWorkoutRequest(String personalCode, Long workout) {
        this.personalCode = personalCode;
        this.workout = workout;
    }
}
