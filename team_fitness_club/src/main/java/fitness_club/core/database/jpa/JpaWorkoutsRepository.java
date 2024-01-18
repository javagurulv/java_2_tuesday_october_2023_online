package fitness_club.core.database.jpa;

import fitness_club.core.domain.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaWorkoutsRepository extends JpaRepository<Workout, Long> {

    List<Workout>findByWorkoutTitle(String workoutsTitle);
}
