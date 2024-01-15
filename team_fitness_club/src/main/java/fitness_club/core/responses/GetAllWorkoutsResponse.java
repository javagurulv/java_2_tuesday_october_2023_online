package fitness_club.core.responses;

import fitness_club.core.domain.AgeGroup;
import fitness_club.core.domain.Workout;

import java.util.List;

public class GetAllWorkoutsResponse extends CoreResponse {

    private List<Workout> workouts;

    public GetAllWorkoutsResponse(List<Workout> workouts) {
        this.workouts = workouts;
    }

    public List<Workout> getWorkouts() {
        return workouts;
    }
}
