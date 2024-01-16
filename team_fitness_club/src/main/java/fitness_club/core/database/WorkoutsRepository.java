package fitness_club.core.database;

import fitness_club.core.domain.Workout;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Component
@Transactional
public class WorkoutsRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Workout> getAllWorkouts() {
        return sessionFactory.getCurrentSession()
                .createQuery("SELECT w FROM Workouts w", Workout.class)
                .getResultList();
    }

    public Workout findWorkoutById(Long id) {
        return sessionFactory.getCurrentSession().
                get(Workout.class, id);
    }

}
