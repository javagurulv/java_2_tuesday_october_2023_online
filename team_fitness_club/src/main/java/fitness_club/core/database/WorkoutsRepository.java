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

    public List<Workouts> getAllWorkouts() {
        return sessionFactory.getCurrentSession()
                .createQuery("SELECT w FROM Workouts w", Workouts.class)
                .getResultList();
    }

    public Workouts findWorkoutById(Long id) {
        return sessionFactory.getCurrentSession().
                get(Workouts.class, id);
    }

}
