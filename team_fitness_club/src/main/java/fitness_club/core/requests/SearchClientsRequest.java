package fitness_club.core.requests;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SearchClientsRequest {

    private String firstName;
    private String lastName;
    private String personalCode;
    private Ordering ordering;
    private Paging paging;

    public SearchClientsRequest(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public SearchClientsRequest(String personaCode) {
        this.personalCode = personaCode;
    }

    public SearchClientsRequest(String firstName, String lastName, Ordering ordering) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ordering = ordering;
    }

    public SearchClientsRequest(String firstName, String lastName, Paging paging) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.paging = paging;
    }

    public SearchClientsRequest(String firstName, String lastName, Ordering ordering, Paging paging) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ordering = ordering;
        this.paging = paging;
    }

    public SearchClientsRequest(String firstName, String lastName, String personalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalCode = personalCode;
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

    public boolean isFirstNameProvided() {
        return this.firstName != null && !this.firstName.isEmpty();
    }

    public boolean isLastNameProvided() {
        return this.lastName != null && !this.lastName.isEmpty();
    }

    public boolean isPersonalCodeProvided() {
        return this.personalCode != null && !this.personalCode.isEmpty();
    }

    public Ordering getOrdering() {
        return ordering;
    }

    public Paging getPaging() {
        return paging;
    }

    @Override
    public String toString() {
        return "SearchClientsRequest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", personalCode='" + personalCode + '\'' +
                '}';
    }
}

