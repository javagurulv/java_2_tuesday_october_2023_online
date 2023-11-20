package fitness_club.core.responses;

import fitness_club.data_vlidation.CoreError;
import fitness_club.data_vlidation.CoreResponse;

import java.util.List;

public class ChangeClientFitnessCentreResponse extends CoreResponse {

    private boolean isClientFitnessCentreChanged;


    public ChangeClientFitnessCentreResponse(List<CoreError> errors) {
        super(errors);
    }

    public ChangeClientFitnessCentreResponse(boolean isClientFitnessCentreChanged) {
        this.isClientFitnessCentreChanged = isClientFitnessCentreChanged;
    }

    public boolean isClientFitnessCentreChanged() {
        return isClientFitnessCentreChanged;
    }

}
