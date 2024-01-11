package fitness_club.core.database.jpa;

import fitness_club.core.domain.FitnessCenters;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//@Repository
public interface JpaFitnessCentersRepository extends JpaRepository<FitnessCenters, Long> {

    List<FitnessCenters>findByFitnessCenterTitle(String fitnessCenterTitle);
}
