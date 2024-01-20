package fitness_club.core.database.jpa;

import fitness_club.core.domain.AgeGroup;
import fitness_club.core.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface JpaAgeGroupRepository extends JpaRepository<AgeGroup, Long> {

    List<AgeGroup>findByAgeGroup(String ageGroup);

}
