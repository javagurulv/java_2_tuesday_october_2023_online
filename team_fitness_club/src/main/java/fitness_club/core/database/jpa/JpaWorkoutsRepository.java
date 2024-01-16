package fitness_club.core.database.jpa;

import fitness_club.core.domain.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//@Repository
public interface JpaWorkoutsRepository extends JpaRepository<Workout, Long> {

    List<Workout>JpaWorkoutsTitle(String workoutsTitle);
}
