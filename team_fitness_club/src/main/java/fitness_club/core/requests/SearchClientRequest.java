package fitness_club.core.requests;

public class SearchClientRequest {

    private String firstName;
    private String lastName;
    private Ordering ordering;
    private Paging paging;

    public SearchClientRequest(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public SearchClientRequest(String firstName, String lastName, Ordering ordering) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ordering = ordering;
    }

    public SearchClientRequest(String firstName, String lastName, Paging paging) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.paging = paging;
    }

    public SearchClientRequest(String firstName, String lastName, Ordering ordering, Paging paging) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ordering = ordering;
        this.paging = paging;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean isFirstNameProvided() {
        return this.firstName != null && !this.firstName.isEmpty();
    }

    public boolean isLastNameProvided() {
        return this.lastName != null && !this.lastName.isEmpty();
    }

    public Ordering getOrdering() {
        return ordering;
    }

    public Paging getPaging() {
        return paging;
    }
}
