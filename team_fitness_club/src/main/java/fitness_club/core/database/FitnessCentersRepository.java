package fitness_club.core.database;

import fitness_club.core.domain.FitnessCenters;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import org.hibernate.query.Query;
import java.util.List;


@Component
@Transactional
public class FitnessCentersRepository {

    @Autowired
    private SessionFactory sessionFactory;


    public void addFitnessCenter(FitnessCenters fitnessCenter) {
        sessionFactory.getCurrentSession().save(fitnessCenter);
    }

    public List<FitnessCenters> selectFitnessCenter(FitnessCenters fitnessCenter) {
        Query query = sessionFactory.getCurrentSession()
                .createQuery("FROM Fitness_centres WHERE fitness_center_id =: fitness_center");
        query.setParameter("fitness_center", fitnessCenter);
        return query.getResultList();
    }

    public List<FitnessCenters> getAllFitnessCenters() {
        return  sessionFactory.getCurrentSession()
                .createQuery("SELECT fc FROM Fitness_centres fc", FitnessCenters.class)
                .getResultList();
    }

    public FitnessCenters getFitnessCenterById(Long id) {
        return sessionFactory.getCurrentSession()
                .get(FitnessCenters.class, id);
    }
}
