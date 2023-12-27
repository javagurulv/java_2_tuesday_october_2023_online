package fitness_club.core.services;

import fitness_club.core.database.ClientRepository;
import fitness_club.core.database.MemberCardRepository;
import fitness_club.core.domain.MemberCard;
import fitness_club.core.requests.AddMemberCardRequest;
import fitness_club.core.responses.AddMemberCardsResponse;
import fitness_club.core.responses.CoreError;
import fitness_club.core.services.data_vlidation.AddMemberCardRequestValidator;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Component
public class AddMemberCardService {

    @Autowired
    private MemberCardRepository memberCardRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AddMemberCardRequestValidator validator;


    public AddMemberCardsResponse execute(AddMemberCardRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new AddMemberCardsResponse(errors);
        }

        MemberCard memberCard = new MemberCard(
                getClientId(request),
                request.getClientAgeGroups(),
                request.getClientWorkout(),
                request.getFitnessCentre(),
                request.getTermOfContract()
        );
        memberCardRepository.save(memberCard);

        return new AddMemberCardsResponse(memberCard);
    }

    private Long getClientId(AddMemberCardRequest request) {
        return clientRepository.getClientIdByPersonalCode(request.getPersonalCode());
    }
}
