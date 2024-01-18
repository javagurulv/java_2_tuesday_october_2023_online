package fitness_club.core.services.validators.memberCard;


import fitness_club.core.database.AgeGroupRepository;
import fitness_club.core.database.ClientRepository;
import fitness_club.core.database.FitnessCenterRepository;
import fitness_club.core.database.WorkoutRepository;
import fitness_club.core.domain.AgeGroup;
import fitness_club.core.domain.Client;
import fitness_club.core.domain.FitnessCenter;
import fitness_club.core.domain.Workout;
import fitness_club.core.requests.MemberCardRegistrationRequest;
import fitness_club.core.responses.CoreError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class MemberCardRegistrationRequestValidator {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AgeGroupRepository ageGroupRepository;

    @Autowired
    private FitnessCenterRepository fitnessCenterRepository;

    @Autowired
    private WorkoutRepository workoutRepository;

    public List<CoreError> validate(MemberCardRegistrationRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateClientNullOrEmpty(request).ifPresent(errors::add);
        validateAgeGroupNullOrEmpty(request).ifPresent(errors::add);
        validateWorkoutNullOrEmpty(request).ifPresent(errors::add);
        validateFitnessCentreNullOrEmpty(request).ifPresent(errors::add);
        validateTermOfContractNotEmpty(request).ifPresent(errors::add);
        validateClientIdExistIdInId(request).ifPresent(errors::add);
        validateAgeGroupIdExistIdInId(request).ifPresent(errors::add);
        validateFitnessCenterIdExistIdInId(request).ifPresent(errors::add);
        validateWorkoutIdExistIdInId(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateClientNullOrEmpty(MemberCardRegistrationRequest request) {
        return request.getClient() == null
                ? Optional.of(new CoreError("clientId", "Field client ID must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateAgeGroupNullOrEmpty(MemberCardRegistrationRequest request) {
        return request.getAgeGroup() == null
                ? Optional.of(new CoreError("ageGroupId", "Field age group ID must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateWorkoutNullOrEmpty(MemberCardRegistrationRequest request) {
        return request.getWorkout() == null
                ? Optional.of(new CoreError("workoutId", "Field workout ID must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateFitnessCentreNullOrEmpty(MemberCardRegistrationRequest request) {
        return request.getFitnessCenter() == null
                ? Optional.of(new CoreError("fitnessCenterId", "Field fitness center ID must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateTermOfContractNotEmpty(MemberCardRegistrationRequest request) {
        return request.getTermOfContract() == null
                ? Optional.of(new CoreError("termOfContract", "Field term of contract must not be empty!"))
                : Optional.empty();
    }

   private Optional<CoreError> validateClientIdExistIdInId(MemberCardRegistrationRequest request) {
        if (request.getClient() != null) {
            Optional<Client> clientOpt = clientRepository.getById(request.getClient());
            return (clientOpt.isEmpty())
                    ? Optional.of(new CoreError("clientId", "Not exist!"))
                    : Optional.empty();
        } else {
            return Optional.empty();
        }
   }
    private Optional<CoreError> validateAgeGroupIdExistIdInId(MemberCardRegistrationRequest request) {
        if (request.getAgeGroup() != null) {
            Optional<AgeGroup> ageGroupOpt = ageGroupRepository.getById(request.getAgeGroup());
            return (ageGroupOpt.isEmpty())
                    ? Optional.of(new CoreError("ageGroupId", "Not exist!"))
                    : Optional.empty();
        } else {
            return Optional.empty();
        }
    }

    private Optional<CoreError> validateFitnessCenterIdExistIdInId(MemberCardRegistrationRequest request) {
        if (request.getFitnessCenter() != null) {
            Optional<FitnessCenter> fitnessCenterOpt = fitnessCenterRepository.getById(request.getFitnessCenter());
            return (fitnessCenterOpt.isEmpty())
                    ? Optional.of(new CoreError("fitnessCenterId", "Not exist!"))
                    : Optional.empty();
        } else {
            return Optional.empty();
        }
    }
    private Optional<CoreError> validateWorkoutIdExistIdInId(MemberCardRegistrationRequest request) {
        if (request.getWorkout() != null) {
            Optional<Workout> workoutOpt = workoutRepository.getById(request.getWorkout());
            return (workoutOpt.isEmpty())
                    ? Optional.of(new CoreError("workoutId", "Not exist!"))
                    : Optional.empty();
        } else {
            return Optional.empty();
        }
    }


}
