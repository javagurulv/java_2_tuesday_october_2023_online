package fitness_club.core.services.validators.memberCard;

import fitness_club.core.database.jpa.JpaAgeGroupRepository;
import fitness_club.core.database.jpa.JpaClientRepository;
import fitness_club.core.database.jpa.JpaFitnessCentersRepository;
import fitness_club.core.database.jpa.JpaWorkoutsRepository;
import fitness_club.core.domain.AgeGroup;
import fitness_club.core.domain.Client;
import fitness_club.core.domain.FitnessCenter;
import fitness_club.core.domain.Workout;
import fitness_club.core.requests.MemberCardRegistrationFormRequest;
import fitness_club.core.responses.CoreError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class MemberCardRegistrationFormRequestValidator {

    @Autowired
    private JpaClientRepository clientRepository;

    @Autowired
    private JpaAgeGroupRepository ageGroupRepository;

    @Autowired
    private JpaFitnessCentersRepository fitnessCenterRepository;

    @Autowired
    private JpaWorkoutsRepository workoutRepository;

    public List<CoreError> validate(MemberCardRegistrationFormRequest request) {
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

    private Optional<CoreError> validateClientNullOrEmpty(MemberCardRegistrationFormRequest request) {
        return request.getClient() == null
                ? Optional.of(new CoreError("clientId", "Field client ID must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateAgeGroupNullOrEmpty(MemberCardRegistrationFormRequest request) {
        return request.getAgeGroup() == null
                ? Optional.of(new CoreError("ageGroupId", "Field age group ID must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateWorkoutNullOrEmpty(MemberCardRegistrationFormRequest request) {
        return request.getWorkout() == null
                ? Optional.of(new CoreError("workoutId", "Field workout ID must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateFitnessCentreNullOrEmpty(MemberCardRegistrationFormRequest request) {
        return request.getFitnessCenter() == null
                ? Optional.of(new CoreError("fitnessCenterId", "Field fitness center ID must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateTermOfContractNotEmpty(MemberCardRegistrationFormRequest request) {
        return request.getTermOfContract() == null
                ? Optional.of(new CoreError("termOfContract", "Field term of contract must not be empty!"))
                : Optional.empty();
    }

   private Optional<CoreError> validateClientIdExistIdInId(MemberCardRegistrationFormRequest request) {
        if (request.getClient() != null) {
            Optional<Client> clientOpt = clientRepository.findById(request.getClient());
            return (clientOpt.isEmpty())
                    ? Optional.of(new CoreError("clientId", "Not exist!"))
                    : Optional.empty();
        } else {
            return Optional.empty();
        }
   }
    private Optional<CoreError> validateAgeGroupIdExistIdInId(MemberCardRegistrationFormRequest request) {
        if (request.getAgeGroup() != null) {
            Optional<AgeGroup> ageGroupOpt = ageGroupRepository.findById(request.getAgeGroup());
            return (ageGroupOpt.isEmpty())
                    ? Optional.of(new CoreError("ageGroupId", "Not exist!"))
                    : Optional.empty();
        } else {
            return Optional.empty();
        }
    }

    private Optional<CoreError> validateFitnessCenterIdExistIdInId(MemberCardRegistrationFormRequest request) {
        if (request.getFitnessCenter() != null) {
            Optional<FitnessCenter> fitnessCenterOpt = fitnessCenterRepository.findById(request.getFitnessCenter());
            return (fitnessCenterOpt.isEmpty())
                    ? Optional.of(new CoreError("fitnessCenterId", "Not exist!"))
                    : Optional.empty();
        } else {
            return Optional.empty();
        }
    }
    private Optional<CoreError> validateWorkoutIdExistIdInId(MemberCardRegistrationFormRequest request) {
        if (request.getWorkout() != null) {
            Optional<Workout> workoutOpt = workoutRepository.findById(request.getWorkout());
            return (workoutOpt.isEmpty())
                    ? Optional.of(new CoreError("workoutId", "Not exist!"))
                    : Optional.empty();
        } else {
            return Optional.empty();
        }
    }


}
