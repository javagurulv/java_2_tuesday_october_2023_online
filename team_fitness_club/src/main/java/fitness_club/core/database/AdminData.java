package fitness_club.core.database;

import fitness_club.core.domain.AgeGroup;
import fitness_club.core.domain.Client;
import fitness_club.core.domain.FitnessCenter;
import fitness_club.core.domain.Workout;

import java.util.List;

public interface AdminData {

    Client findClientById(Long id);

    void addAgeGroup(AgeGroup ageGroup);
    List<AgeGroup> getAllAgeGroups();

    void addWorkout(Workout workout);

    List<Workout> getAllWorkouts();

    void addFitnessCenter(FitnessCenter fitnessCenter);
    List<FitnessCenter> getAllFitnessCenters();
}
