package fitness_club.core.services;

import fitness_club.core.database.MemberCardRepository;
import fitness_club.core.database.jpa.JpaMemberCardRepository;
import fitness_club.core.requests.GetMemberCardRequest;
import fitness_club.core.responses.CoreError;
import fitness_club.core.responses.GetMemberCardResponse;
import fitness_club.core.services.validators.memberCard.GetMemberCardRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class GetMemberCardService {

    @Autowired
    private JpaMemberCardRepository memberCardRepository;

    @Autowired
    private GetMemberCardRequestValidator validator;

    public GetMemberCardResponse execute(GetMemberCardRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new GetMemberCardResponse();
        }
        return memberCardRepository.findById(request.getId())
                .map(GetMemberCardResponse::new)
                .orElseGet(()->{
                    errors.add(new CoreError("id", "Not found!"));
                            return new GetMemberCardResponse(errors);
                        });
    }
}
