package fitness_club.core.responses;

import fitness_club.core.domain.MemberCard;
import java.util.List;

public class AddMemberCardsResponse extends CoreResponse {

    private MemberCard newMemberCard;

    public AddMemberCardsResponse(List<CoreError> errors) {
        super(errors);
    }

    public AddMemberCardsResponse(MemberCard newMemberCard) {
        this.newMemberCard = newMemberCard;
    }

    public MemberCard getNewMemberCard() {
        return newMemberCard;
    }
}
