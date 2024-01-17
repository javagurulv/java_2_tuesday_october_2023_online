package fitness_club.core.services;

import fitness_club.core.database.ClientRepository;
import fitness_club.core.requests.DeleteClientByIdRequest;
import fitness_club.core.responses.CoreError;
import fitness_club.core.responses.DeleteClientByIdResponse;
import fitness_club.core.services.validators.client.DeleteClientByIdRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class DeleteClientByIdService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private DeleteClientByIdRequestValidator validator;

    public DeleteClientByIdResponse executeByClientId(DeleteClientByIdRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new  DeleteClientByIdResponse(errors);
        }
        boolean isClientRemoved = clientRepository.deleteById(request.getId());
        return new  DeleteClientByIdResponse(isClientRemoved);
    }
}

