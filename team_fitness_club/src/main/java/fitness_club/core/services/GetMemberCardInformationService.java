package fitness_club.core.services;

import fitness_club.core.database.jpa.JpaMemberCardRepository;
import fitness_club.core.domain.MemberCard;
import fitness_club.core.requests.GetMemberCardInformationRequest;
import fitness_club.core.responses.GetMemberCardInformationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class GetMemberCardInformationService {
    @Autowired
    private JpaMemberCardRepository memberCardRepository;

    public GetMemberCardInformationResponse execute(GetMemberCardInformationRequest request) {
        List<MemberCard> memberCards = memberCardRepository.findAll();
        return new GetMemberCardInformationResponse(memberCards);
    }
}
