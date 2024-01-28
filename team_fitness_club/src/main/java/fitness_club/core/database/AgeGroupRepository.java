package fitness_club.core.database;

import fitness_club.core.domain.AgeGroup;

import java.util.List;
import java.util.Optional;

public interface AgeGroupRepository {
    Optional<AgeGroup> getById(Long id);

    List<AgeGroup> getAllAgeGroups();
}
