package lv.javaguru.java2.createCake.core.cake.services.cakes;

import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.Cake;
import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.CreateCakeProcess;
import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.database.ui_users_cakes.UIDatabaseCakes;
import lv.javaguru.java2.createCake.core.cake.request_and_response.CoreError;
import lv.javaguru.java2.createCake.core.cake.request_and_response.add_cake.AddCakeRequestForUnregistUser;
import lv.javaguru.java2.createCake.core.cake.request_and_response.add_cake.AddCakeResponse;
import lv.javaguru.java2.createCake.core.cake.request_and_response.add_cake.AddCakeValidation;

import java.util.List;

public class AddCakeServiceForUnregistr {
    private UIDatabaseCakes databaseCakes;
    private AddCakeValidation validation;
    private CreateCakeProcess process = new CreateCakeProcess() ;


    public AddCakeServiceForUnregistr(UIDatabaseCakes databaseCakes, AddCakeValidation validation){
        this.databaseCakes=databaseCakes;
        this.validation=validation;
    }

    public AddCakeResponse execute (AddCakeRequestForUnregistUser request){
        List<CoreError> errors = validation.validate(request);
        if (!errors.isEmpty()){
            return new AddCakeResponse(errors);
        }
        Cake cake = process.createCakeForNotRegistrate(request.getClientLogin());
        databaseCakes.save(cake);
        return new AddCakeResponse(cake);
    }


}
