package lv.javaguru.java2.createCake.core.cake.UI.add_cake;

import lv.javaguru.java2.createCake.core.cake.UI.UIAction;
import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.User;
import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.database.ui_users_cakes.DatabaseOfCake;
import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.database.ui_users_cakes.UIDatabaseCakes;
import lv.javaguru.java2.createCake.core.cake.request_and_response.add_cake.AddCakeRequestForRegist;
import lv.javaguru.java2.createCake.core.cake.request_and_response.add_cake.AddCakeResponse;
import lv.javaguru.java2.createCake.core.cake.request_and_response.add_cake.AddCakeValidation;
import lv.javaguru.java2.createCake.core.cake.services.users.AddCakeServiceForRegistr;

public class AddCakeUIActionForRegist implements UIAction {
    private AddCakeValidation validation = new AddCakeValidation();
    private UIDatabaseCakes cakes = new DatabaseOfCake();

    private AddCakeServiceForRegistr serviceForRegistr = new AddCakeServiceForRegistr(cakes,validation);

    public AddCakeUIActionForRegist ( AddCakeServiceForRegistr serviceForRegistr){
        this.serviceForRegistr=serviceForRegistr;
    }
    @Override
    public void execute(String userLogin) {

    }

    @Override
    public void execute(User user) {
        AddCakeRequestForRegist request = new AddCakeRequestForRegist(user);
        AddCakeResponse response = serviceForRegistr.execute(request);
        response.getNewCake().toString();
    }

    @Override
    public void execute() {

    }

}
