package fitness_club.core.services;

import fitness_club.core.database.*;
import fitness_club.core.domain.*;
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
    private AdminData adminData;
    @Autowired
    private MemberCardRepository memberCardRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AgeGroupsRepository ageGroupsRepository;
    @Autowired
    private FitnessCentersRepository fitnessCentersRepository;
    @Autowired
    private WorkoutsRepository workoutsRepository;
    @Autowired
    private AddMemberCardRequestValidator validator;


    public AddMemberCardsResponse execute(AddMemberCardRequest request) {
        List<CoreError> errors = validator.validate(request);
        return (!errors.isEmpty())
                ? new AddMemberCardsResponse(errors)
                : memberCard(request);
    }

   private  AddMemberCardsResponse memberCard(AddMemberCardRequest request) {

        AddMemberCardsResponse response = new AddMemberCardsResponse();

       response.setClient(request.getClient());
       response.setAgeGroup(request.getAgeGroup());
       response.setWorkout(request.getWorkout());
       response.setFitnessCentre(request.getFitnessCentre());
       return response;
   }
}
