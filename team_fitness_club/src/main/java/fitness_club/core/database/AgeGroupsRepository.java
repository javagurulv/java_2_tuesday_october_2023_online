package fitness_club.core.database;

import fitness_club.core.domain.AgeGroups;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Component
@Transactional
public class AgeGroupsRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(AgeGroups ageGroup) {
        sessionFactory.getCurrentSession().save(ageGroup);
    }

    public AgeGroups findById(Long id) {
        return sessionFactory.getCurrentSession().
                get(AgeGroups.class, id);
    }

    public List<AgeGroups> getAllAgeGroups() {
        return sessionFactory.getCurrentSession()
                .createQuery("SELECT * FROM Age_groups", AgeGroups.class)
                .getResultList();
    }

}
