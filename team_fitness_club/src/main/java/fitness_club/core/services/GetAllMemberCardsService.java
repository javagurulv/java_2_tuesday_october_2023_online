package fitness_club.core.services;


import fitness_club.core.database.MemberCardRepository;
import fitness_club.core.domain.MemberCard;
import fitness_club.core.requests.GetAllMemberCardsRequest;
import fitness_club.core.responses.GetAllMemberCardsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllMemberCardsService {

    @Autowired
    private MemberCardRepository memberCardRepository;

    public GetAllMemberCardsResponse execute(GetAllMemberCardsRequest request) {
        List<MemberCard> memberCards = memberCardRepository.getAllMemberCards();
        return new GetAllMemberCardsResponse(memberCards);
    }
}
