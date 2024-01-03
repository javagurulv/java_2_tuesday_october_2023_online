package fitness_club.core.database.jpa;

import fitness_club.core.domain.MemberCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaMemberCardRepository extends JpaRepository<MemberCard, Long> {

}
