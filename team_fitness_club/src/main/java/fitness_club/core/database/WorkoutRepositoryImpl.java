package fitness_club.core.database;

import fitness_club.core.domain.Workout;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Component
@Transactional
public class WorkoutRepositoryImpl implements WorkoutRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Workout> getAllWorkouts() {
        return sessionFactory.getCurrentSession()
                .createQuery("SELECT w FROM Workouts w", Workout.class)
                .getResultList();
    }

    public Optional<Workout> getById(Long id) {
        Workout workout = sessionFactory.getCurrentSession().get(Workout.class, id);
        if (workout == null) {
            return Optional.empty();
        } else {
            return Optional.of(workout);
        }
    }

}
