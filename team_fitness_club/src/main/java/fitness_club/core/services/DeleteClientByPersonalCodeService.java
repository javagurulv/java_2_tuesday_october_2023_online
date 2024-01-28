package fitness_club.core.services;

import fitness_club.core.database.jpa.JpaClientRepository;
import fitness_club.core.requests.DeleteClientByPersonalCodeRequest;
import fitness_club.core.responses.CoreError;
import fitness_club.core.responses.DeleteClientByPersonalCodeResponse;
import fitness_club.core.services.validators.client.DeleteClientByPersonalCodeRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Component
//@Transactional
public class DeleteClientByPersonalCodeService {

    /*@Autowired
    private JpaClientRepository clientRepository;
    @Autowired
    private DeleteClientByPersonalCodeRequestValidator validator;


    public DeleteClientByPersonalCodeResponse executeByPersonalCode(DeleteClientByPersonalCodeRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new DeleteClientByPersonalCodeResponse(errors);
        }
        boolean isClientRemoved = clientRepository.deleteByPersonalCode(request.getPersonalCode());
        return new DeleteClientByPersonalCodeResponse(isClientRemoved);
    }

     */

}

