package lv.javaguru.java2.cakeConstructor.newApp.core.services;

import lv.javaguru.java2.cakeConstructor.newApp.core.database.jpa.JpaCakeRepository;
import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Cake;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.GetAllCakesRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.GetAllCakesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class GetAllCakesService {
    @Autowired private JpaCakeRepository cakeRepository;

    public GetAllCakesResponse execute(GetAllCakesRequest request) {
        List<Cake> cakes = cakeRepository.findAll();
        return new GetAllCakesResponse(cakes);
    }
}
