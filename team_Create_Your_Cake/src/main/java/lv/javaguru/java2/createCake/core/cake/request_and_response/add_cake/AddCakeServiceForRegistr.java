package lv.javaguru.java2.createCake.core.cake.request_and_response.add_cake;

import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.Cake;
import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.CreateCakeProcess;
import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.database.ui_users_cakes.UIDatabaseCakes;
import lv.javaguru.java2.createCake.core.cake.request_and_response.CoreError;

import java.util.List;

public class AddCakeServiceForRegistr {
    private UIDatabaseCakes databaseCakes;
    private AddCakeValidation validation;
    private CreateCakeProcess process ;


    public AddCakeServiceForRegistr(UIDatabaseCakes databaseCakes, AddCakeValidation validation){
        this.databaseCakes=databaseCakes;
        this.validation=validation;
    }

  //  public AddCakeResponse execute (AddCakeRequestForRegist request){
  //      List<CoreError> errors = validation.validate(request.getUser());
  //      if (!errors.isEmpty()){
   //         return new AddCakeResponse(errors);
   //     }
   //     Cake cake = process.createCakeForRegistrate(request.getUser());
   //     databaseCakes.save(cake);
   //     return new AddCakeResponse(cake);
  //  }

}
