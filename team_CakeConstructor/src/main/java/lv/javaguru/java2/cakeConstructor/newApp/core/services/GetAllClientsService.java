package lv.javaguru.java2.cakeConstructor.newApp.core.services;

import lv.javaguru.java2.cakeConstructor.newApp.core.database.jpa.JpaClientRepository;
import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Client;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.GetAllClientsRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.GetAllClientsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class GetAllClientsService {
    @Autowired private JpaClientRepository clientRepository;

    public GetAllClientsResponse execute(GetAllClientsRequest request) {
        List<Client> clients = clientRepository.findAll();
        return new GetAllClientsResponse(clients);
    }
}
