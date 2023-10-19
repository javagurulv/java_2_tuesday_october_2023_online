package fitness_club.requests;

import fitness_club.domain.ClientAgeGroups;
import fitness_club.domain.Workouts;

public class ClientAndWorkoutRequest {

    private String firstName;
    private String lastName;
    private String personalCode;
    private ClientAgeGroups clientAgeGroup;
    private Workouts workout;

    public ClientAndWorkoutRequest(String firstName, String lastName, String personalCode, ClientAgeGroups clientAgeGroup, Workouts workout) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalCode = personalCode;
        this.clientAgeGroup = clientAgeGroup;
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

    public ClientAgeGroups getClientAgeGroup() {
        return clientAgeGroup;
    }

}
