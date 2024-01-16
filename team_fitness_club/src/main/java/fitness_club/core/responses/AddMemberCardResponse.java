package fitness_club.core.responses;

import fitness_club.core.domain.MemberCard;
import lombok.*;

import java.util.Date;
import java.util.List;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddMemberCardResponse extends CoreResponse {

    private MemberCard newMemberCard;

    public AddMemberCardResponse(List<CoreError> errors) {
        super(errors);
    }

}
