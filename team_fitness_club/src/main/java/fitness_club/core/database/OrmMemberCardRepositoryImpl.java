package fitness_club.core.database;

import fitness_club.core.domain.Client;
import fitness_club.core.domain.MemberCard;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class OrmMemberCardRepositoryImpl implements MemberCardRepository {

    @Autowired private SessionFactory sessionFactory;


    @Override
    public void save(MemberCard memberCard) { sessionFactory.getCurrentSession().save(memberCard); }

    @Override
    public List<MemberCard> getAllMemberCards() {
        return sessionFactory.getCurrentSession()
                .createQuery("SELECT b FROM MemberCard b", MemberCard.class)
                .getResultList();
    }

    @Override
    public boolean isClientWorkoutsChangedByPersonalCode(Long clientId, Long newWorkout) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "update MemberCard set workout_id = :newWorkout where client_id = :clientId");
        query.setParameter("newWorkout", newWorkout);
        query.setParameter("clientId", clientId);
        int result = query.executeUpdate();
        return result == 1;
    }

    @Override
    public boolean isClientAgeGroupChangedByPersonalCode(Long clientId, Long newAgeGroup) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "update MemberCard set age_group_id = :newAgeGroup where client_id = :clientId");
        query.setParameter("newAgeGroup", newAgeGroup);
        query.setParameter("clientId", clientId);
        int result = query.executeUpdate();
        return result == 1;
    }

    @Override
    public boolean isClientFitnessCentreChangedByPersonalCode(Long clientId, Long newFitnessCentre) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "update MemberCard set fitness_centre_id = :newFitnessCentre where client_id = :clientId");
        query.setParameter("newFitnessCentre", newFitnessCentre);
        query.setParameter("clientId", clientId);
        int result = query.executeUpdate();
        return result == 1;
    }
}
