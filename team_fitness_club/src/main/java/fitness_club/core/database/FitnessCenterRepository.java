package fitness_club.core.database;

import fitness_club.core.domain.FitnessCenter;

import java.util.List;
import java.util.Optional;

public interface FitnessCenterRepository {
    Optional<FitnessCenter> getById(Long id);

    List<FitnessCenter> getAllFitnessCenters();
}
