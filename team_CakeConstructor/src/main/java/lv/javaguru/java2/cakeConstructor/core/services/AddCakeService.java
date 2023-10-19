package lv.javaguru.java2.cakeConstructor.core.services;

import lv.javaguru.java2.cakeConstructor.core.database.DataBase;
import lv.javaguru.java2.cakeConstructor.core.domain.Cake;
import lv.javaguru.java2.cakeConstructor.core.domain.ListOfIngridients;
import lv.javaguru.java2.cakeConstructor.core.request.AddCakeRequest;
import lv.javaguru.java2.cakeConstructor.core.responses.AddCakeResponse;
import lv.javaguru.java2.cakeConstructor.core.responses.CoreError;

import java.util.List;

public class AddCakeService {

    private DataBase dataBase;
    private AddCakeValidator validator;
    private ListOfIngridients list = new ListOfIngridients();
    public AddCakeService (DataBase dataBase, AddCakeValidator validator){
        this.dataBase=dataBase;
        this.validator = validator;
    }

    public AddCakeResponse execute(AddCakeRequest request){
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()){
            return new AddCakeResponse(errors);
        }
        Cake cake = list.createCake(request.getClientId());
        dataBase.add(cake);
        return new AddCakeResponse(cake);
    }
}
