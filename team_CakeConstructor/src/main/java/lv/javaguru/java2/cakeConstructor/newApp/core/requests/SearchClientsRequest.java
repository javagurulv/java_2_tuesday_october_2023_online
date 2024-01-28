package lv.javaguru.java2.cakeConstructor.newApp.core.requests;

public class SearchClientsRequest {
    private String firstName;

    private String lastName;

    private Ordering ordering;

    private Paging paging;

    public SearchClientsRequest() {
    }

    public SearchClientsRequest(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isFirstNameProvided() {
        return this.firstName != null && !this.firstName.isEmpty();
    }

    public boolean isLastNameProvided() { return this.lastName != null && !this.lastName.isEmpty(); }
    public Ordering getOrdering() {
        return ordering;
    }

    public void setOrdering(Ordering ordering) {
        this.ordering = ordering;
    }

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }
}

