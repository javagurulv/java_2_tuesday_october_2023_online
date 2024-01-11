package fitness_club.core.database;

import fitness_club.core.domain.Workouts;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Component
@Transactional
public class WorkoutsRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void addWorkout(Workouts workout) {
        sessionFactory.getCurrentSession().save(workout);
    }

    public List<Workouts> selectWorkout(Workouts workout) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("FROM Workouts WHERE workout_id =: workout");
        query.setParameter("workout", workout);
        return query.getResultList();
    }

    public List<Workouts> getAllWorkouts() {
        return  sessionFactory.getCurrentSession()
                .createQuery("SELECT w FROM Workouts w", Workouts.class)
                .getResultList();
    }

    public Workouts findWorkoutById(Long id) {
        return sessionFactory.getCurrentSession().
                get(Workouts.class, id);
    }

}
