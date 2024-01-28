package fitness_club.core.services;


import fitness_club.core.database.jpa.*;
import fitness_club.core.domain.*;
import fitness_club.core.requests.MemberCardRegistrationRequest;
import fitness_club.core.responses.CoreError;
import fitness_club.core.responses.MemberCardRegistrationResponse;
import fitness_club.core.services.validators.memberCard.MemberCardRegistrationRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Component
@Transactional
public class MemberCardRegistrationService {
    @Autowired
    private JpaClientRepository clientRepository;
    @Autowired
    private JpaAgeGroupRepository ageGroupRepository;
    @Autowired
    private JpaFitnessCentersRepository fitnessCenterRepository;

    @Autowired
    private JpaWorkoutsRepository workoutRepository;
    @Autowired
    private JpaMemberCardRepository memberCardRepository;

    @Autowired
    private MemberCardRegistrationRequestValidator validator;

    public MemberCardRegistrationResponse execute(MemberCardRegistrationRequest request) throws ParseException {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new MemberCardRegistrationResponse(errors);
        }

        Client client = clientRepository.findByPersonalCode(request.getClient());
        AgeGroup ageGroup = ageGroupRepository.getReferenceById(request.getAgeGroup());
        FitnessCenter fitnessCenter = fitnessCenterRepository.getReferenceById(request.getFitnessCenter());
        Workout workout = workoutRepository.getReferenceById(request.getWorkout());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        MemberCard memberCard = new MemberCard();
        memberCard.setClient(client);
        memberCard.setAgeGroup(ageGroup);
        memberCard.setFitnessCenter(fitnessCenter);
        memberCard.setWorkout(workout);
        memberCard.setTermOfContract(dateFormat.parse(request.getTermOfContract()));

        memberCardRepository.save(memberCard);

        return new MemberCardRegistrationResponse(null);
    }
}
