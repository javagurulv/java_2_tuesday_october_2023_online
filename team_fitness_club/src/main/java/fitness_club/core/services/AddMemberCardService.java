package fitness_club.core.services;

import fitness_club.core.database.AgeGroupsRepository;
import fitness_club.core.database.ClientRepository;
import fitness_club.core.database.MemberCardRepository;
import fitness_club.core.database.jpa.JpaAgeGroupRepository;
import fitness_club.core.database.jpa.JpaClientRepository;
import fitness_club.core.domain.AgeGroups;
import fitness_club.core.domain.MemberCard;
import fitness_club.core.requests.AddMemberCardRequest;
import fitness_club.core.responses.AddMemberCardsResponse;
import fitness_club.core.responses.CoreError;
import fitness_club.core.services.vlidators.AddMemberCardRequestValidator;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Component
@Transactional
public class AddMemberCardService {

    @Autowired
    private MemberCardRepository memberCardRepository;
    @Autowired
    private JpaClientRepository clientRepository;
    @Autowired
    private JpaAgeGroupRepository ageGroupsRepository;
    @Autowired
    private AddMemberCardRequestValidator validator;


    public AddMemberCardsResponse execute(AddMemberCardRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new AddMemberCardsResponse(errors);
        }

        MemberCard memberCard = new MemberCard(
                request.getClient(),
            request.getAgeGroups());
           //    request.getWorkouts(),
            //  request.getFitnessCentre(),
            // request.getTermOfContract()

        memberCardRepository.save(memberCard);

        return new AddMemberCardsResponse(memberCard);
    }

   // private Long getClientId(AddMemberCardRequest request) {
      //  return clientRepository.getClientIdByPersonalCode(request.getClient().getPersonalCode());
  //  }
}
