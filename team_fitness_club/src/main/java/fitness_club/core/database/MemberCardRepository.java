package fitness_club.core.database;

import fitness_club.core.domain.AgeGroups;
import fitness_club.core.domain.FitnessCenters;
import fitness_club.core.domain.MemberCard;
import fitness_club.core.domain.Workouts;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class MemberCardRepository {

    @Autowired
    private SessionFactory sessionFactory;


    public void AddMemberCard(MemberCard memberCard) {
        sessionFactory.getCurrentSession().save(memberCard);
    }

    public MemberCard getMemberCardById(Long id) {
        return sessionFactory.getCurrentSession().
                get(MemberCard.class, id);
    }


    public List<MemberCard> getAllWorkouts(Workouts workout) {
        Query<MemberCard> query = sessionFactory.getCurrentSession()
                .createQuery("SELECT mc FROM MemberCard mc WHERE mc.workout_id = :workout ", MemberCard.class);
        query.setParameter("workout", workout);
        return query.getResultList();
    }
    public List<MemberCard> getAllFitnessCenters(FitnessCenters fitnessCenter) {
        Query<MemberCard> query = sessionFactory.getCurrentSession()
                .createQuery("SELECT mc FROM MemberCard mc WHERE mc.fitness_center_id = :fitness_center", MemberCard.class);
        query.setParameter("fitness_center", fitnessCenter);
        return query.getResultList();
    }

    public List<MemberCard> getAllAgeGroups(AgeGroups ageGroup) {
        Query<MemberCard> query = sessionFactory.getCurrentSession()
                .createQuery("SELECT mc FROM MemberCard mc WHERE mc.age_group_id = :age_group", MemberCard.class);
        query.setParameter("age_group", ageGroup);
        return query.getResultList();
    }

    public boolean isClientWorkoutsChangedByPersonalCode(Long clientId, Long newWorkout) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "update MemberCard set workout_id = :newWorkout where client_id = :clientId");
        query.setParameter("newWorkout", newWorkout);
        query.setParameter("clientId", clientId);
        int result = query.executeUpdate();
        return result == 1;
    }


    public boolean isClientAgeGroupChangedByPersonalCode(Long clientId, Long newAgeGroup) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "update MemberCard set age_group_id = :newAgeGroup where client_id = :clientId");
        query.setParameter("newAgeGroup", newAgeGroup);
        query.setParameter("clientId", clientId);
        int result = query.executeUpdate();
        return result == 1;
    }


    public boolean isClientFitnessCentreChangedByPersonalCode(Long clientId, Long newFitnessCentre) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "update MemberCard set fitness_centre_id = :newFitnessCentre where client_id = :clientId");
        query.setParameter("newFitnessCentre", newFitnessCentre);
        query.setParameter("clientId", clientId);
        int result = query.executeUpdate();
        return result == 1;
    }

}
