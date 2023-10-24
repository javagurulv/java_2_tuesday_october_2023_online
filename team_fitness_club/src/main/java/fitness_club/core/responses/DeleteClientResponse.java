package fitness_club.core.responses;

import fitness_club.data_vlidation.CoreError;
import fitness_club.data_vlidation.CoreResponse;

import java.util.List;

public class DeleteClientResponse extends CoreResponse {

    private boolean ClientDeleted;
    private List<CoreError> errors;

    public DeleteClientResponse(List<CoreError> errors) {
        this.errors = errors;
    }

    public DeleteClientResponse() { }

    public DeleteClientResponse(boolean ClientDeleted) { this.ClientDeleted = ClientDeleted; }

    public boolean isClientDeleted() { return ClientDeleted; }

    public boolean containsErrors() {
        return errors != null && errors.size() > 0;
    }

    public List<CoreError> getErrors() {
        return errors;
    }
}
