package fitness_club.domain;

import java.io.Serializable;
import java.util.Objects;

public class Client implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private String personalCode;
    private ClientAgeGroups clientAgeGroup;
    private Workouts workouts;

    public Client(String firstName, String lastName, String personalCode, ClientAgeGroups clientAgeGroup, Workouts workouts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalCode = personalCode;
        this.clientAgeGroup = clientAgeGroup;
        this.workouts = workouts;
    }

    public Client(String name, String lastName, String personalCode) {
        this.firstName = name;
        this.lastName = lastName;
        this.personalCode = personalCode;
    }

    public Client(String personalCode) {this.personalCode = personalCode;

    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setWorkouts(Workouts workouts) {
        this.workouts = workouts;
    }

    public void setPersonalCode(String personalCode) {
        this.personalCode = personalCode;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Workouts getWorkouts() {
        return workouts;
    }

    public String getPersonalCode() {
        return personalCode;
    }

    public ClientAgeGroups getClientAgeGroup() {
        return clientAgeGroup;
    }

    public void setClientAgeGroup(ClientAgeGroups clientAgeGroup) {
        this.clientAgeGroup = clientAgeGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(firstName, client.firstName) && Objects.equals(lastName, client.lastName) && Objects.equals(personalCode, client.personalCode) && clientAgeGroup == client.clientAgeGroup && workouts == client.workouts;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, personalCode, clientAgeGroup, workouts);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", personalCode='" + personalCode + '\'' +
                ", clientAgeGroup=" + clientAgeGroup +
                ", workouts=" + workouts +
                '}';
    }
}
