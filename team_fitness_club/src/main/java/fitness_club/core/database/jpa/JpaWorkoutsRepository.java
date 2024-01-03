package fitness_club.core.database.jpa;

import fitness_club.core.domain.FitnessCentres;
import fitness_club.core.domain.Workouts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaWorkoutsRepository extends JpaRepository<Workouts, Long> {

    List<Workouts>JpaWorkouts(String workout);

    @Query("SELECT w FROM Workouts w WHERE w.workout LIKE %:workout%")
    List<Workouts> findByWorkoutLike(@Param("workout") String workout);
}
