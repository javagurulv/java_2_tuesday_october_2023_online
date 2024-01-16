package fitness_club.core.database;

import fitness_club.core.domain.AgeGroup;
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

    public AgeGroup findById(Long id) {
        return sessionFactory.getCurrentSession().get(AgeGroup.class, id);
    }

    public List<AgeGroup> getAllAgeGroups() {
        return sessionFactory.getCurrentSession()
                .createQuery("SELECT a  FROM Age_groups a", AgeGroup.class)
                .getResultList();
    }


}
