package fitness_club.core.responses;

import fitness_club.core.services.data_vlidation.CoreError;
import fitness_club.core.services.data_vlidation.CoreResponse;

import java.util.List;

public class ChangeClientAgeGroupResponse extends CoreResponse {

    private boolean isClientAgeGroupChanged;


    public ChangeClientAgeGroupResponse(List<CoreError> errors) {
        super(errors);
    }

    public ChangeClientAgeGroupResponse(boolean isClientAgeGroupChanged) {
        this.isClientAgeGroupChanged = isClientAgeGroupChanged;
    }

    public boolean isClientAgeGroupChanged() {
        return isClientAgeGroupChanged;
    }

}
