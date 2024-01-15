package fitness_club.core.database.jpa;

import fitness_club.core.domain.AgeGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
//@Repository
public interface JpaAgeGroupRepository extends JpaRepository<AgeGroup, Long> {

    List<AgeGroup>findByAgeGroupTitle(String ageGroupTitle);
}
