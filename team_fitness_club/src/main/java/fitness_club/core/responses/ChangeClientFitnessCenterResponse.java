package fitness_club.core.responses;

import java.util.List;

public class ChangeClientFitnessCenterResponse extends CoreResponse {

    private boolean isClientFitnessCentreChanged;


    public ChangeClientFitnessCenterResponse(List<CoreError> errors) {
        super(errors);
    }

    public ChangeClientFitnessCenterResponse(boolean isClientFitnessCentreChanged) {
        this.isClientFitnessCentreChanged = isClientFitnessCentreChanged;
    }

    public boolean isClientFitnessCentreChanged() {
        return isClientFitnessCentreChanged;
    }

}
