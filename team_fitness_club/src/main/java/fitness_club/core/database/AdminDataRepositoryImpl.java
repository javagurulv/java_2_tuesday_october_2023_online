package fitness_club.core.database;

import fitness_club.core.domain.AgeGroups;
import fitness_club.core.domain.Client;
import fitness_club.core.domain.FitnessCenters;
import fitness_club.core.domain.Workouts;
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
    public void addAgeGroup(AgeGroups ageGroup) {
        sessionFactory.getCurrentSession().save(ageGroup);
    }

    @Override
    public List<AgeGroups> getAllAgeGroups() {
        return sessionFactory.getCurrentSession()
                .createQuery("SELECT a  FROM Age_groups a", AgeGroups.class)
                .getResultList();
    }

    @Override
    public void addWorkout(Workouts workout) {
        sessionFactory.getCurrentSession().save(workout);
    }

    @Override
    public List<Workouts> getAllWorkouts() {
        return  sessionFactory.getCurrentSession()
                .createQuery("SELECT w FROM Workouts w", Workouts.class)
                .getResultList();
    }

    @Override
    public void addFitnessCenter(FitnessCenters fitnessCenter) {
        sessionFactory.getCurrentSession().save(fitnessCenter);
    }

    @Override
    public List<FitnessCenters> getAllFitnessCenters() {
        return  sessionFactory.getCurrentSession()
                .createQuery("SELECT fc FROM Fitness_centres fc", FitnessCenters.class)
                .getResultList();
    }
}
