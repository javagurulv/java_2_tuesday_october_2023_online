package fitness_club.core.services.data_vlidation;


import fitness_club.core.database.ClientRepository;
import fitness_club.core.domain.Client;
import fitness_club.core.requests.AddMemberCardRequest;
import fitness_club.core.responses.CoreError;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
@NoArgsConstructor
@AllArgsConstructor
public class AddMemberCardRequestValidator {

    @Autowired
    private ClientRepository clientRepository;

    public List<CoreError> validate(AddMemberCardRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validatePersonalCodeNotEmpty(request).ifPresent(errors::add);
        validateAgeGroupNotEmpty(request).ifPresent(errors::add);
        validateWorkoutNotEmpty(request).ifPresent(errors::add);
        validateFitnessCentreNotEmpty(request).ifPresent(errors::add);
        validateTermOfContractNotEmpty(request).ifPresent(errors::add);
        validateClientExist(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validatePersonalCodeNotEmpty(AddMemberCardRequest request) {
        return request.getPersonalCode() == null || request.getPersonalCode().isEmpty()
                ? Optional.of(new CoreError("personalCode", "Field personal code must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateAgeGroupNotEmpty(AddMemberCardRequest request) {
        return request.getClientAgeGroups() == null
                ? Optional.of(new CoreError("personalCode", "Field personal code must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateWorkoutNotEmpty(AddMemberCardRequest request) {
        return request.getClientWorkout() == null
                ? Optional.of(new CoreError("personalCode", "Field personal code must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateFitnessCentreNotEmpty(AddMemberCardRequest request) {
        return request.getFitnessCentre() == null
                ? Optional.of(new CoreError("personalCode", "Field personal code must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateTermOfContractNotEmpty(AddMemberCardRequest request) {
        return request.getTermOfContract() == null
                ? Optional.of(new CoreError("personalCode", "Field personal code must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateClientExist(AddMemberCardRequest request) {
        List<Client> clients = clientRepository.findByPersonalCode(request.getPersonalCode());
        return (clients.isEmpty())
                ? Optional.of(new CoreError("Client", "There is no such client in database!"))
                : Optional.empty();
    }
}
