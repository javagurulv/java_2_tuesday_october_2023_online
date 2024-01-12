package fitness_club.core.services;

import fitness_club.core.database.ClientRepository;
import fitness_club.core.database.jpa.JpaAgeGroupRepository;
import fitness_club.core.database.jpa.JpaClientRepository;
import fitness_club.core.database.jpa.JpaMemberCardRepository;
import fitness_club.core.domain.AgeGroups;
import fitness_club.core.domain.Client;
import fitness_club.core.domain.MemberCard;
import fitness_club.core.requests.SetAgeGroupToClientRequest;
import fitness_club.core.responses.CoreError;
import fitness_club.core.responses.SetAgeGroupToClientResponse;
import fitness_club.core.services.vlidators.ageGroup.SetAgeGroupToClientRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Component
//@Transactional
public class SetAgeGroupToClientService {
    @Autowired private SetAgeGroupToClientRequestValidator validator;
    @Autowired private JpaClientRepository clientRepository;
    @Autowired private JpaAgeGroupRepository ageGroupRepository;
    @Autowired private JpaMemberCardRepository memberCardRepository;


    public SetAgeGroupToClientResponse execute(SetAgeGroupToClientRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new SetAgeGroupToClientResponse(errors);
        }
     //   Client client = clientRepository.getReferenceById(request.getClientId());
       // AgeGroups ageGroup =ageGroupRepository.getReferenceById(request.getAgeGroupId());

        MemberCard memberCard = new MemberCard();
       // memberCard.setClient(request.getClientId().);
      //  memberCard.setAgeGroup(request.getAgeGroupId());

        memberCardRepository.save(memberCard);

        return new SetAgeGroupToClientResponse(null);
    }
}
