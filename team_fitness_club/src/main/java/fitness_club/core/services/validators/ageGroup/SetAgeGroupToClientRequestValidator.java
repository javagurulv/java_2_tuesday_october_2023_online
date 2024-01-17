package fitness_club.core.services.validators.ageGroup;

import fitness_club.core.database.jpa.JpaAgeGroupRepository;
import fitness_club.core.database.jpa.JpaClientRepository;
import fitness_club.core.domain.AgeGroup;
import fitness_club.core.domain.Client;
import fitness_club.core.requests.SetAgeGroupToClientRequest;
import fitness_club.core.responses.CoreError;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//@Component
public class SetAgeGroupToClientRequestValidator {

    @Autowired
    private JpaClientRepository clientRepository;

    @Autowired
    private JpaAgeGroupRepository ageGroupsRepository;

    public List<CoreError> validate(SetAgeGroupToClientRequest request) {
        List<CoreError> errors = new ArrayList<>();
        validateClientIdEmpty(request).ifPresent(errors::add);
        validateAgeGroupIdEmpty(request).ifPresent(errors::add);
        validateClientIdExistInDb(request).ifPresent(errors::add);
        validateAgeGroupIdExistInDb(request).ifPresent(errors::add);
        return errors;
    }

    private Optional<CoreError> validateClientIdEmpty(SetAgeGroupToClientRequest request) {
        return request.getClientId() == null
                ? Optional.of(new CoreError("clientId", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateAgeGroupIdEmpty(SetAgeGroupToClientRequest request) {
        return request.getAgeGroupId() == null
                ? Optional.of(new CoreError("ageGroupId", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validateClientIdExistInDb(SetAgeGroupToClientRequest request) {
        if (request.getClientId() != null) {
            Optional<Client> clientOpt = clientRepository.findById(request.getClientId());
            return clientOpt.isEmpty()
                    ? Optional.of(new CoreError("clientId", "Not exist!"))
                    : Optional.empty();
        } else {
            return Optional.empty();
        }
    }
    private Optional<CoreError> validateAgeGroupIdExistInDb(SetAgeGroupToClientRequest request) {
        if (request.getAgeGroupId() != null) {
            Optional<AgeGroup> ageGroupOpt = ageGroupsRepository.findById(request.getAgeGroupId());
            return ageGroupOpt.isEmpty()
                    ? Optional.of(new CoreError("ageGroupId", "Not exist!"))
                    : Optional.empty();
        } else {
            return Optional.empty();
        }
    }
}