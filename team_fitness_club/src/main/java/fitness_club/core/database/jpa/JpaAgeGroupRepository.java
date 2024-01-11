package fitness_club.core.database.jpa;

import fitness_club.core.domain.AgeGroups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
//@Repository
public interface JpaAgeGroupRepository extends JpaRepository<AgeGroups, Long> {

    List<AgeGroups>findByAgeGroupTitle(String ageGroupTitle);
}
