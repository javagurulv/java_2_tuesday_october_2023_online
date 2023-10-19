package fitness_club.requests;

public class DeleteClientRequest {

    String ClientPersonalCodeToDelete;

    public DeleteClientRequest(String ClientPersonalCodeToDelete) { this.ClientPersonalCodeToDelete = ClientPersonalCodeToDelete; }

    public String getClientPersonalCodeToDelete() { return ClientPersonalCodeToDelete; }
}
