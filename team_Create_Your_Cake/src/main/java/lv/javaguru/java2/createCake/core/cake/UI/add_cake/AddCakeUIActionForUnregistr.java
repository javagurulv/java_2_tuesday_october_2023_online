package lv.javaguru.java2.createCake.core.cake.UI.add_cake;

import lv.javaguru.java2.createCake.core.cake.UI.UIAction;
import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.User;
import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.database.ui_users_cakes.DatabaseOfCake;
import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.database.ui_users_cakes.UIDatabaseCakes;
import lv.javaguru.java2.createCake.core.cake.request_and_response.add_cake.AddCakeRequestForUnregistUser;
import lv.javaguru.java2.createCake.core.cake.request_and_response.add_cake.AddCakeResponse;
import lv.javaguru.java2.createCake.core.cake.request_and_response.add_cake.AddCakeValidation;
import lv.javaguru.java2.createCake.core.cake.services.cakes.AddCakeServiceForUnregistr;

public class AddCakeUIActionForUnregistr implements UIAction {
    private AddCakeValidation validation = new AddCakeValidation();
    private UIDatabaseCakes cakes = new DatabaseOfCake();

    private AddCakeServiceForUnregistr serviceForUnregistr = new AddCakeServiceForUnregistr(cakes,validation);

    public AddCakeUIActionForUnregistr(AddCakeServiceForUnregistr serviceForUnregistr){
        this.serviceForUnregistr=serviceForUnregistr;
    }
    @Override
    public void execute(String userLogin) {
        AddCakeRequestForUnregistUser request = new AddCakeRequestForUnregistUser(userLogin);
        AddCakeResponse response = serviceForUnregistr.execute(request);
        response.getNewCake().toString();

    }

    @Override
    public void execute(User user) {

    }

    @Override
    public void execute() {

    }


}
