package fitness_club.core.services;

import fitness_club.core.database.ClientRepository;
import fitness_club.core.database.jpa.JpaClientRepository;
import fitness_club.core.requests.GetClientRequest;
import fitness_club.core.responses.CoreError;
import fitness_club.core.responses.GetClientResponse;
import fitness_club.core.services.validators.client.GetClientRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class GetClientService {

    @Autowired
    private JpaClientRepository clientRepository;

    @Autowired
    private GetClientRequestValidator validator;

    public GetClientResponse execute(GetClientRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new GetClientResponse();
        }
        return clientRepository.findById(request.getId())
                .map(GetClientResponse::new)
                .orElseGet(()->{
                    errors.add(new CoreError("id", "Not found!"));
                            return new GetClientResponse(errors);
                        });
    }
}
