package fitness_club.core.requests;

public class SearchClientRequest {

    private String firstName;
    private String lastName;
    private Paging paging;

    public SearchClientRequest(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public SearchClientRequest(String firstName, String lastName, Paging paging) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.paging = paging;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Paging getPaging() {
        return paging;
    }

    public boolean isFirstNameProvided() {
        return this.firstName != null && !this.firstName.isEmpty();
    }

    public boolean isLastNameProvided() {
        return this.lastName != null && !this.lastName.isEmpty();
    }

}
