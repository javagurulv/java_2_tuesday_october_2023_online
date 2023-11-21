package fitness_club.core.responses;

import fitness_club.core.services.data_vlidation.CoreError;
import fitness_club.core.services.data_vlidation.CoreResponse;

import java.util.List;

public class ChangeClientWorkoutsResponse extends CoreResponse {

    private boolean isClientWorkoutsChanged;


    public ChangeClientWorkoutsResponse(List<CoreError> errors) {
        super(errors);
    }

    public ChangeClientWorkoutsResponse(boolean isClientWorkoutsChanged) {
        this.isClientWorkoutsChanged = isClientWorkoutsChanged;
    }

    public boolean isClientWorkoutsChanged() {
        return isClientWorkoutsChanged;
    }

}
