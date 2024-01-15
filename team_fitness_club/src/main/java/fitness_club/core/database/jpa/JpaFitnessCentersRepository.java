package fitness_club.core.database.jpa;

import fitness_club.core.domain.FitnessCenter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//@Repository
public interface JpaFitnessCentersRepository extends JpaRepository<FitnessCenter, Long> {

    List<FitnessCenter>findByFitnessCenterTitle(String fitnessCenterTitle);
}
