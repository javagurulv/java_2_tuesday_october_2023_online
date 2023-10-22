package fitness_club.core.requests;

public class DeleteClientRequest {

    private String personalCode;

    public DeleteClientRequest(String personalCode) {
        this.personalCode = personalCode;
    }

    public String getPersonalCode() {
        return personalCode;
    }
}
