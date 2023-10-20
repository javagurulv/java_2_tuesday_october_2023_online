package fitness_club.requests;

public class DeleteClientRequest {

    private String personalCode;;

    public DeleteClientRequest(String personalCode) {
        this.personalCode = personalCode;
    }

    public String getPersonalCode() {
        return personalCode;
    }
}
