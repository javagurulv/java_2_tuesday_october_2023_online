package fitness_club.core.requests;

import fitness_club.core.domain.ClientAgeGroups;
import fitness_club.core.domain.FitnessCentre;
import fitness_club.core.domain.Workouts;

public class AddClientRequest {

    private String firstName;
    private String lastName;
    private String personalCode;
    private ClientAgeGroups clientAgeGroup;
    private Workouts workout;
    private FitnessCentre fitnessCentre;

    public AddClientRequest(String firstName, String lastName, String personalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalCode = personalCode;
       // this.clientAgeGroup = clientAgeGroup;
        //this.workout = workout;
       // this.fitnessCentre = fitnessCentre;
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

    public FitnessCentre getFitnessCentre() { return  fitnessCentre; }

}
