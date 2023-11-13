package lv.javaguru.java2.cakeConstructor.privious.cake.services;
import lv.javaguru.java2.cakeConstructor.privious.cake.database.DateBaseIf;
import lv.javaguru.java2.cakeConstructor.privious.cake.domain.Cake;
import lv.javaguru.java2.cakeConstructor.privious.cake.responses.CoreError;
import lv.javaguru.java2.cakeConstructor.privious.cake.domain.ListOfIngridients;
import lv.javaguru.java2.cakeConstructor.privious.cake.request.AddCakeRequest;
import lv.javaguru.java2.cakeConstructor.privious.cake.responses.AddCakeResponse;

import java.util.List;

public class AddCakeService {

    private DateBaseIf dataBase;
    private AddCakeValidator validator;
    private ListOfIngridients list = new ListOfIngridients();
    public AddCakeService (DateBaseIf dataBase, AddCakeValidator validator){
        this.dataBase=dataBase;
        this.validator = validator;
    }

    public AddCakeResponse execute(AddCakeRequest request){
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()){
            return new AddCakeResponse(errors);
        }
        Cake cake = list.createCake(request.getClientLogin());
        dataBase.add(cake);
        return new AddCakeResponse(cake);
    }
}
