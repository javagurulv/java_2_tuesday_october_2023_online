package fitness_club.core.database;

import fitness_club.core.domain.AgeGroups;
import fitness_club.core.domain.Client;
import fitness_club.core.domain.FitnessCenters;
import fitness_club.core.domain.Workouts;

import java.util.List;

public interface AdminData {

    Client findClientById(Long id);

    void addAgeGroup(AgeGroups ageGroup);
    List<AgeGroups> getAllAgeGroups();

    void addWorkout(Workouts workout);

    List<Workouts> getAllWorkouts();

    void addFitnessCenter(FitnessCenters fitnessCenter);
    List<FitnessCenters> getAllFitnessCenters();
}
