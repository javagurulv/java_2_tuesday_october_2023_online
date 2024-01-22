package fitness_club.core.responses;

import fitness_club.core.domain.MemberCard;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetMemberCardResponse extends CoreResponse {

    private MemberCard memberCard;

    public GetMemberCardResponse(List<CoreError> errors) {
        super(errors);
    }
}
