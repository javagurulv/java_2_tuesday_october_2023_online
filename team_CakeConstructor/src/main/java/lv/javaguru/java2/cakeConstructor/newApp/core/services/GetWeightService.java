package lv.javaguru.java2.cakeConstructor.newApp.core.services;

import lv.javaguru.java2.cakeConstructor.newApp.core.database.jpa.JpaCakeIngredientRepository;
import lv.javaguru.java2.cakeConstructor.newApp.core.database.jpa.JpaCakeRepository;
import lv.javaguru.java2.cakeConstructor.newApp.core.database.jpa.JpaIngredientRepository;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.GetWeightRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.GetWeightResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.validators.GetWeightRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class GetWeightService {

    @Autowired private GetWeightRequestValidator validator;
    @Autowired private JpaIngredientRepository ingredientRepository;
    @Autowired private JpaCakeRepository cakeRepository;
    @Autowired private JpaCakeIngredientRepository cakeIngredientRepository;


    public GetWeightResponse execute(GetWeightRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new GetWeightResponse(errors);
        }

        return cakeRepository.findById(request.getId())
                .map(order -> {
                    order.setWeight(cakeRepository.sumWeight(request.getId()));
                    return new GetWeightResponse(List.of());
                })
                .orElseGet(() -> {
                    errors.add(new CoreError("id", "Not found!"));
                    return new GetWeightResponse(errors);
                });
    }


}
