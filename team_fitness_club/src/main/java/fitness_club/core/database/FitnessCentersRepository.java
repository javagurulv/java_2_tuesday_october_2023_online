package fitness_club.core.database;

import fitness_club.core.domain.FitnessCenter;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Component
@Transactional
public class FitnessCentersRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public List<FitnessCenter> getAllFitnessCenters() {
        return  sessionFactory.getCurrentSession()
                .createQuery("SELECT fc FROM Fitness_centres fc", FitnessCenter.class)
                .getResultList();
    }

    public FitnessCenter getFitnessCenterById(Long id) {
        return sessionFactory.getCurrentSession()
                .get(FitnessCenter.class, id);
    }
}
