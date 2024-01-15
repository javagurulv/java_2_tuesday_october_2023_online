package fitness_club.core.database;

import fitness_club.core.domain.AgeGroup;
import fitness_club.core.domain.Client;
import fitness_club.core.domain.FitnessCenter;
import fitness_club.core.domain.Workout;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Component
@Transactional
public class AdminDataRepositoryImpl implements AdminData {

    @Autowired private SessionFactory sessionFactory;

    @Override
    public Client findClientById(Long id) {
        return sessionFactory.getCurrentSession().
                get(Client.class, id);
    }

    @Override
    public void addAgeGroup(AgeGroup ageGroup) {
        sessionFactory.getCurrentSession().save(ageGroup);
    }

    @Override
    public List<AgeGroup> getAllAgeGroups() {
        return sessionFactory.getCurrentSession()
                .createQuery("SELECT a  FROM Age_groups a", AgeGroup.class)
                .getResultList();
    }

    @Override
    public void addWorkout(Workout workout) {
        sessionFactory.getCurrentSession().save(workout);
    }

    @Override
    public List<Workout> getAllWorkouts() {
        return  sessionFactory.getCurrentSession()
                .createQuery("SELECT w FROM Workouts w", Workout.class)
                .getResultList();
    }

    @Override
    public void addFitnessCenter(FitnessCenter fitnessCenter) {
        sessionFactory.getCurrentSession().save(fitnessCenter);
    }

    @Override
    public List<FitnessCenter> getAllFitnessCenters() {
        return  sessionFactory.getCurrentSession()
                .createQuery("SELECT fc FROM Fitness_centres fc", FitnessCenter.class)
                .getResultList();
    }
}
