package fitness_club.core.responses;

import fitness_club.core.domain.MemberCard;

import java.util.List;

public class GetMemberCardInformationResponse extends CoreResponse {

    private List<MemberCard> memberCardInformation;

    public GetMemberCardInformationResponse(List<MemberCard> memberCards) {
        this.memberCardInformation = memberCards;
    }

    public List<MemberCard> getMemberCardInformation() {
        return memberCardInformation;
    }
}