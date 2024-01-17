package fitness_club.core.responses;

import java.util.List;

public class DeleteClientByIdResponse extends CoreResponse {

    private boolean clientRemoved;


    public DeleteClientByIdResponse(List<CoreError> errors) {
        super(errors);
    }

    public DeleteClientByIdResponse(boolean clientRemoved) {
        this.clientRemoved = clientRemoved;
    }

    public boolean isClientRemoved() {
        return clientRemoved;
    }

}
