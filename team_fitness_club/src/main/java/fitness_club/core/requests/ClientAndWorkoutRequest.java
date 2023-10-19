package fitness_club.core.requests;

import fitness_club.core.domain.Workouts;

public class ClientAndWorkoutRequest {

    private String firstName;
    private String lastName;
    private String personalCode;
    private Workouts workout;

    public ClientAndWorkoutRequest(String firstName, String lastName, String personalCode, Workouts workout) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalCode = personalCode;
        this.workout = workout;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPersonalCode() {
        return personalCode;
    }

    public Workouts getWorkout() {
        return workout;
    }

}
