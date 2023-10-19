package fitness_club.responses;

public class DeleteClientResponse {

    private boolean ClientDeleted;

    public DeleteClientResponse(boolean ClientDeleted) { this.ClientDeleted = ClientDeleted; }

    public boolean isClientDeleted() { return ClientDeleted; }
}
