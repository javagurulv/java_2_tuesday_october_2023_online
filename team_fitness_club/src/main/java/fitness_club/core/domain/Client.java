package fitness_club.core.domain;

import java.io.Serializable;
import java.util.Objects;

public class Client implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private String personalCode;
    private Workouts workouts;


    public Client(String firstName, String lastName, String personalCode, Workouts workouts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalCode = personalCode;
        this.workouts = workouts;
    }

    public Client(String name, String lastName, String personalCode) {
        this.firstName = name;
        this.lastName = lastName;
        this.personalCode = personalCode;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(firstName, client.firstName) && Objects.equals(lastName, client.lastName) && Objects.equals(personalCode, client.personalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, personalCode, workouts);
    }

    @Override
    public String toString() {
        return "fitness_club.core.domain.Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", personalCode='" + personalCode + '\'' +
                ", workouts=" + workouts +
                '}';
    }
}
