package fitness_club.core.database;

import fitness_club.core.domain.MemberCard;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class ClientCardRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(MemberCard memberCard) {
        sessionFactory.getCurrentSession().save(memberCard);
    }

    public MemberCard getById(Long id) {
        return sessionFactory.getCurrentSession().get(MemberCard.class, id);
    }



}
