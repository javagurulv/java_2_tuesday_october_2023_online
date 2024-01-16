package fitness_club.core.services.vlidators;


import fitness_club.core.requests.AddMemberCardRequest;
import fitness_club.core.responses.CoreError;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class AddMemberCardRequestValidator {

  //  @Autowired
   // private ClientRepository clientRepository;

    public List<CoreError> validate(AddMemberCardRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateClientNullOrEmpty(request).ifPresent(errors::add);
        validateAgeGroupNullOrEmpty(request).ifPresent(errors::add);
        validateWorkoutNullOrEmpty(request).ifPresent(errors::add);
        validateFitnessCentreNullOrEmpty(request).ifPresent(errors::add);
        validateTermOfContractNotEmpty(request).ifPresent(errors::add);
      //  validateClientExist(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateClientNullOrEmpty(AddMemberCardRequest request) {
        return request.getClient() == null
                ? Optional.of(new CoreError("clientId", "Field client ID must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateAgeGroupNullOrEmpty(AddMemberCardRequest request) {
        return request.getAgeGroup() == null
                ? Optional.of(new CoreError("ageGroupId", "Field age group ID must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateWorkoutNullOrEmpty(AddMemberCardRequest request) {
        return request.getWorkout()== null
                ? Optional.of(new CoreError("workoutId", "Field workout ID must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateFitnessCentreNullOrEmpty(AddMemberCardRequest request) {
        return request.getFitnessCentre() == null
                ? Optional.of(new CoreError("fitnessCenterId", "Field fitness center ID must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateTermOfContractNotEmpty(AddMemberCardRequest request) {
        return request.getTermOfContract() == null
                ? Optional.of(new CoreError("termOfContract", "Field term of contract must not be empty!"))
                : Optional.empty();
    }

   /* private Optional<CoreError> validateClientExist(AddMemberCardRequest request) {
        List<Client> clients = clientRepository.findByPersonalCode(request.getClient().getPersonalCode());
        return (clients.isEmpty())
                ? Optional.of(new CoreError("Client", "There is no such client in database!"))
                : Optional.empty();
    }

    */
}
