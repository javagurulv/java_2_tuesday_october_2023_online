package lv.javaguru.java2.cakeConstructor.newApp.core.services;

import lv.javaguru.java2.cakeConstructor.newApp.core.database.jpa.JpaCakeRepository;
import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Cake;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.CreateCakeRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CreateCakeResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.validators.CreateCakeRequestValidator;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class CreateCakeService {

    @Autowired private CreateCakeRequestValidator validator;
    @Autowired private JpaCakeRepository cakeRepository;


    public CreateCakeResponse execute(CreateCakeRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new CreateCakeResponse(errors);
        }

        Cake cake = new Cake();
        cake.setCakeName(request.getCakeName());
        cakeRepository.save(cake);



        return new CreateCakeResponse(null);
    }

}
