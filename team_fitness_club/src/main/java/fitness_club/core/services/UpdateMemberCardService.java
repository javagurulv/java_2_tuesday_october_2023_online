package fitness_club.core.services;


import fitness_club.core.database.MemberCardRepository;
import fitness_club.core.database.jpa.JpaMemberCardRepository;
import fitness_club.core.requests.UpdateMemberCardRequest;
import fitness_club.core.responses.CoreError;
import fitness_club.core.responses.UpdateMemberCardResponse;
import fitness_club.core.services.validators.memberCard.UpdateMemberCardRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class UpdateMemberCardService {
    @Autowired
    private JpaMemberCardRepository memberCardRepository;

    @Autowired
    private UpdateMemberCardRequestValidator validator;

    public UpdateMemberCardResponse execute(UpdateMemberCardRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new UpdateMemberCardResponse();
        }
        return memberCardRepository.findById(request.getId())
                .map(memberCard -> {
                    memberCard.setClient(request.getNewClient());
                    memberCard.setAgeGroup(request.getNewAgeGroup());
                    memberCard.setFitnessCentre(request.getNewFitnessCenter());
                    memberCard.setWorkout(request.getNewWorkout());
                    return new UpdateMemberCardResponse(memberCard);
                })
                .orElseGet(() -> {
                    errors.add(new CoreError("id", "Not found!"));
                    return new UpdateMemberCardResponse(errors);
                });
    }
}
