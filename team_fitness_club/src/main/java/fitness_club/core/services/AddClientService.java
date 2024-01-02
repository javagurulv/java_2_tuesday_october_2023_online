package fitness_club.core.services;

import fitness_club.core.database.ClientRepository;
import fitness_club.core.database.ClientRepositoryImpl;
import fitness_club.core.domain.Client;
import fitness_club.core.requests.AddClientRequest;
import fitness_club.core.responses.AddClientResponse;
import fitness_club.core.services.vlidators.AddClientRequestValidator;
import fitness_club.core.responses.CoreError;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Component
@Transactional
public class AddClientService {

    @Autowired
    private ClientRepositoryImpl clientRepositoryImp;
    @Autowired
    private AddClientRequestValidator validator;


    public AddClientResponse execute(AddClientRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new AddClientResponse(errors);
        }

        Client client = new Client(request.getFirstName(), request.getLastName(), request.getPersonalCode());
        clientRepositoryImp.save(client);

        return new AddClientResponse(client);
    }

   /* private AddClientResponse buildErrorResponse(List<CoreError> errors) {
        return new AddCl b  ientResponse(errors);
    }

    private AddClientResponse addNewClient(AddClientRequest request) {
        Client client = new Client(
                request.getFirstName(),
                request.getLastName(),
                request.getPersonalCode());
                //request.getClientAgeGroup(),
                //request.getWorkout(),
               // request.getFitnessCentre());
        database.save(client);
        return new AddClientResponse(client);
    }

    */

}
