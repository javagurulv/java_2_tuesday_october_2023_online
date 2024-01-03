package fitness_club.core.database.jpa;

import fitness_club.core.domain.AgeGroups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface JpaAgeGroupRepository extends JpaRepository<AgeGroups, Long> {

    List<AgeGroups>findByAgeGroups(String ageGroup);

    @Query("SELECT ag FROM Age_groups ag WHERE ag.age_group LIKE %:age_group%")
    List<AgeGroups> findByAgeGroupLike(@Param("ageGroup") String ageGroup);
}
