package fitness_club.core.database;

import fitness_club.core.domain.Workouts;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


//@Component
//@Transactional
public class WorkoutsRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(Workouts workout) {
        sessionFactory.getCurrentSession().save(workout);
    }

    public Workouts findById(Long id) {
        return sessionFactory.getCurrentSession().
                get(Workouts.class, id);
    }

}
