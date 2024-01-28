package fitness_club.core.database;

import fitness_club.core.domain.Workout;

import java.util.List;
import java.util.Optional;

public interface WorkoutRepository {
    Optional<Workout> getById(Long id);

    List<Workout> getAllWorkouts();
}
