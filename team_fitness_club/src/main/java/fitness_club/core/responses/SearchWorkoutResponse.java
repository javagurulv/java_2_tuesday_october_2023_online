package fitness_club.core.responses;

import fitness_club.core.domain.Workout;

import java.util.List;

public class SearchWorkoutResponse extends CoreResponse {
    private List<Workout> foundWorkouts;
    public SearchWorkoutResponse(List<Workout> foundWorkouts, List<CoreError> errors) {
        super(errors);
        this.foundWorkouts = foundWorkouts;
    }

    public List<Workout> foundWorkouts() { return foundWorkouts; }
}
