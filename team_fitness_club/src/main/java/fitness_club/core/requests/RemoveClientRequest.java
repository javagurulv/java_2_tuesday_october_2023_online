package fitness_club.core.requests;

public class RemoveClientRequest {

    private String personalCode;

    public RemoveClientRequest(String personalCode) {
        this.personalCode = personalCode;
    }

    public String getPersonalCode() {
        return personalCode;
    }
}
