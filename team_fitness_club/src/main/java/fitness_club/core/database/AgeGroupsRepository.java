package fitness_club.core.database;

import fitness_club.core.domain.AgeGroups;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


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

}
