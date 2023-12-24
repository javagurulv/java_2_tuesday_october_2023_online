package fitness_club.core.responses;

import java.util.List;

public class ChangeClientWorkoutResponse extends CoreResponse {

    private boolean isClientWorkoutsChanged;


    public ChangeClientWorkoutResponse(List<CoreError> errors) {
        super(errors);
    }

    public ChangeClientWorkoutResponse(boolean isClientWorkoutsChanged) {
        this.isClientWorkoutsChanged = isClientWorkoutsChanged;
    }

    public boolean isClientWorkoutsChanged() {
        return isClientWorkoutsChanged;
    }

}
