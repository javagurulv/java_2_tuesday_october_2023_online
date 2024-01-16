package lv.javaguru.java2.cakeConstructor.newApp.core.services;

import lv.javaguru.java2.cakeConstructor.newApp.core.database.ClientRepository;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.RemoveClientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.RemoveClientResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.validators.RemoveClientRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class RemoveClientService {

    @Autowired private ClientRepository clientRepository;
    @Autowired private RemoveClientRequestValidator validator;


    public RemoveClientResponse execute(RemoveClientRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new RemoveClientResponse(errors);
        }
        boolean isClientRemoved = clientRepository.deleteById(request.getClientIdToRemove());
        return new RemoveClientResponse(isClientRemoved);
    }
}
