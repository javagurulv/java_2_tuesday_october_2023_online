package lv.javaguru.java2.cakeConstructor.core.cake.services;

import lv.javaguru.java2.cakeConstructor.core.cake.database.DataBase;
import lv.javaguru.java2.cakeConstructor.core.cake.domain.Cake;
import lv.javaguru.java2.cakeConstructor.core.cake.responses.CoreError;
import lv.javaguru.java2.cakeConstructor.core.cake.domain.ListOfIngridients;
import lv.javaguru.java2.cakeConstructor.core.cake.request.AddCakeRequest;
import lv.javaguru.java2.cakeConstructor.core.cake.responses.AddCakeResponse;

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
        Cake cake = list.createCake(request.getClientLogin());
        dataBase.add(cake);
        return new AddCakeResponse(cake);
    }
}
