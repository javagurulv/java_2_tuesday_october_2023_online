package fitness_club.core.responses;

import fitness_club.core.domain.MemberCard;
import lombok.Getter;

import java.util.List;

@Getter
public class GetAllMemberCardsResponse extends CoreResponse {

    private List<MemberCard> memberCards;

    public GetAllMemberCardsResponse(List<MemberCard> memberCards) {
        this.memberCards = memberCards;
    }

}