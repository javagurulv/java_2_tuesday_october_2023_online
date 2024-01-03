package fitness_club.core.database.jpa;

import fitness_club.core.domain.AgeGroups;
import fitness_club.core.domain.FitnessCentres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaFitnessCentersRepository extends JpaRepository<FitnessCentres, Long> {

    List<FitnessCentres>findByFitnessCenters(String fitnessCenter);

    @Query("SELECT fc FROM Fitness_centres fc WHERE fc.fitness_centre LIKE %:fitness_centre%")
    List<FitnessCentres> findByFitnessCenterLike(@Param("fitnessCenter") String fitnessCenter);
}
