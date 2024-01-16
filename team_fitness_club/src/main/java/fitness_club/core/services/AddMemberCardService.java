package fitness_club.core.services;

import fitness_club.core.database.*;
import fitness_club.core.domain.Client;
import fitness_club.core.domain.MemberCard;
import fitness_club.core.requests.AddMemberCardRequest;
import fitness_club.core.responses.AddMemberCardResponse;
import fitness_club.core.responses.CoreError;
import fitness_club.core.services.vlidators.AddMemberCardRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class AddMemberCardService {
    @Autowired private MemberCardRepository memberCardRepository;

    @Autowired
    private AddMemberCardRequestValidator validator;

    public AddMemberCardResponse execute(AddMemberCardRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new AddMemberCardResponse(errors);
        }

        MemberCard memberCard = new MemberCard(
                request.getClient(),
                request.getAgeGroup(),
                request.getFitnessCentre(),
                request.getWorkout());
        memberCardRepository.save(memberCard);

        return new AddMemberCardResponse(memberCard);
    }
}
