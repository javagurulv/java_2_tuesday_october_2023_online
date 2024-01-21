package fitness_club.core.services;


import fitness_club.core.database.jpa.*;
import fitness_club.core.domain.*;
import fitness_club.core.requests.MemberCardRegistrationFormRequest;
import fitness_club.core.responses.MemberCardRegistrationFormResponse;
import fitness_club.core.responses.CoreError;
import fitness_club.core.services.validators.memberCard.MemberCardRegistrationFormRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
@Transactional
public class MemberCardRegistrationFormService {
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
    private MemberCardRegistrationFormRequestValidator validator;

    public MemberCardRegistrationFormResponse execute(MemberCardRegistrationFormRequest request) throws ParseException {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new MemberCardRegistrationFormResponse(errors);
        }

        Client client = clientRepository.findByPersonalCodeLike(request.getClient().toString()).get(0);
        AgeGroup ageGroup = ageGroupRepository.getReferenceById(request.getAgeGroup());
        FitnessCenter fitnessCenter = fitnessCenterRepository.getReferenceById(request.getFitnessCenter());
        Workout workout = workoutRepository.getReferenceById(request.getWorkout());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        MemberCard memberCard = new MemberCard();
        memberCard.setClient(client);
        memberCard.setAgeGroup(ageGroup);
        memberCard.setFitnessCentre(fitnessCenter);
        memberCard.setWorkout(workout);
        memberCard.setTermOfContract(dateFormat.parse(request.getTermOfContract()));

        memberCardRepository.save(memberCard);

        return new MemberCardRegistrationFormResponse(null);
    }
}
