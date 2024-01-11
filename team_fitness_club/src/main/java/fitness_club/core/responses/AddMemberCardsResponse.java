package fitness_club.core.responses;

import fitness_club.core.domain.MemberCard;
import lombok.*;

import java.util.Date;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddMemberCardsResponse extends CoreResponse {

    private MemberCard memberCard;
    private Long client;
    private Long ageGroup;
    private Long workout;
    private Long fitnessCentre;
    private Date termOfContract;

    public AddMemberCardsResponse(List<CoreError> errors) {
        super(errors);
    }

}
