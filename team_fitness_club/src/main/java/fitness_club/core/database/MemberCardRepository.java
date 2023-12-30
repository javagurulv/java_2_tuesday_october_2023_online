package fitness_club.core.database;

import fitness_club.core.domain.MemberCard;
import fitness_club.core.domain.MemberCardDto;

import java.util.List;

public interface MemberCardRepository {


    void save(MemberCard memberCard);

    MemberCard getByPersonalCode(String personalCode);

    List<MemberCard> getAllMemberCards();

    boolean isClientWorkoutsChangedByPersonalCode(Long clientId, Long newWorkout);

    boolean isClientAgeGroupChangedByPersonalCode(Long clientId, Long newAgeGroup);

    boolean isClientFitnessCentreChangedByPersonalCode(Long clientId, Long newAgeGroup);
}
