package fitness_club.core.requests;

import fitness_club.core.domain.*;
import lombok.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.sound.midi.MetaMessage;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class AddMemberCardRequest {

    private MemberCard memberCard;
    private Long client;
    private Long ageGroup;
    private Long workout;
    private Long fitnessCentre;
    private Date termOfContract;

    public AddMemberCardRequest(Long client, Long ageGroup, Long workout, Long fitnessCenter, Date termOfContract) {
    }
}
