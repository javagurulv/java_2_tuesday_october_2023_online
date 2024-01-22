package fitness_club.core.responses;

import fitness_club.core.domain.Client;
import fitness_club.core.domain.MemberCard;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMemberCardResponse extends CoreResponse {

    private MemberCard updateMemberCard;

    public UpdateMemberCardResponse(List<CoreError> errors) {
        super(errors);
    }

}
