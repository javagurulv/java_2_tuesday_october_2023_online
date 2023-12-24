package fitness_club.core.responses;

import fitness_club.core.domain.MemberCard;
import fitness_club.core.domain.MemberCardDto;

import java.util.List;

public class GetAllMemberCardsResponse extends CoreResponse {

    private List<MemberCard> memberCards;

    public GetAllMemberCardsResponse(List<MemberCard> memberCards) {
        this.memberCards = memberCards;
    }

    public List<MemberCard> getMemberCards() {
        return memberCards;
    }
}