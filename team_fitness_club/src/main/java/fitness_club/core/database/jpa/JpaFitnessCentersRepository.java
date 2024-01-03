package fitness_club.core.database.jpa;

import fitness_club.core.domain.FitnessCentres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaFitnessCentersRepository extends JpaRepository<FitnessCentres, Long> {

    List<FitnessCentres>findByFitnessCenterTitle(String fitnessCenterTitle);
}
