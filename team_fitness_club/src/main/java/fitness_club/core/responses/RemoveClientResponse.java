package fitness_club.core.responses;

import fitness_club.core.services.data_vlidation.CoreError;
import fitness_club.core.services.data_vlidation.CoreResponse;

import java.util.List;

public class RemoveClientResponse extends CoreResponse {

    private boolean clientRemoved;


    public RemoveClientResponse(List<CoreError> errors) {
        super(errors);
    }

    public RemoveClientResponse(boolean clientRemoved) {
        this.clientRemoved = clientRemoved;
    }

    public boolean isClientRemoved() {
        return clientRemoved;
    }

}
