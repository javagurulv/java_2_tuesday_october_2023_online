package fitness_club.core.services;


import fitness_club.core.database.*;
import fitness_club.core.database.jpa.*;
import fitness_club.core.domain.*;
import fitness_club.core.requests.MemberCardRegistrationRequest;
import fitness_club.core.responses.MemberCardRegistrationResponse;
import fitness_club.core.responses.CoreError;
import fitness_club.core.services.validators.memberCard.MemberCardRegistrationRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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

    public MemberCardRegistrationResponse execute(MemberCardRegistrationRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new MemberCardRegistrationResponse(errors);
        }

        Client client = clientRepository.getReferenceById(request.getClient());
        AgeGroup ageGroup = ageGroupRepository.getReferenceById(request.getAgeGroup());
        FitnessCenter fitnessCenter = fitnessCenterRepository.getReferenceById(request.getFitnessCenter());
        Workout workout = workoutRepository.getReferenceById(request.getWorkout());
        MemberCard memberCard = new MemberCard();
        memberCard.setClient(client);
        memberCard.setAgeGroup(ageGroup);
        memberCard.setFitnessCentre(fitnessCenter);
        memberCard.setWorkout(workout);

        memberCardRepository.save(memberCard);

        return new MemberCardRegistrationResponse(null);
    }
}
