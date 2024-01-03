package fitness_club.core.database;

import fitness_club.core.domain.FitnessCentres;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


//@Component
//@Transactional
public class FitnessCentersRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(FitnessCentres fitnessCentre) {

        sessionFactory.getCurrentSession().save(fitnessCentre);
    }

    public FitnessCentres findById(Long id) {

        return sessionFactory.getCurrentSession()
                .get(FitnessCentres.class, id);
    }
}
