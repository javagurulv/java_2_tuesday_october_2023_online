package lv.javaguru.java2.createCake.core.cake.UI.add_cake;

import lv.javaguru.java2.createCake.core.cake.UI.UIAction;
import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.User;
import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.database.ui_users_cakes.DatabaseOfCake;
import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.database.ui_users_cakes.UIDatabaseCakes;
import lv.javaguru.java2.createCake.core.cake.request_and_response.add_cake.AddCakeRequestForUnregistUser;
import lv.javaguru.java2.createCake.core.cake.request_and_response.add_cake.AddCakeResponse;
import lv.javaguru.java2.createCake.core.cake.request_and_response.add_cake.AddCakeValidation;
import lv.javaguru.java2.createCake.core.cake.services.cakes.AddCakeServiceForUnregistr;

import java.util.Scanner;

public class AddCakeForUnregistrUIActionApp implements UIAction{
    private static UIDatabaseCakes cakes = new DatabaseOfCake();
    private static AddCakeValidation validation = new AddCakeValidation();
    private static AddCakeServiceForUnregistr service = new AddCakeServiceForUnregistr(cakes,validation);
    private static Scanner scan = new Scanner(System.in);


    @Override
    public void execute(String userLogin) {

    }

    @Override
    public void execute(User user) {

    }

    @Override
    public void execute() {
        System.out.println("Please enter you phone number");
        String userLogin = scan.nextLine();
        AddCakeRequestForUnregistUser request = new AddCakeRequestForUnregistUser(userLogin);
        AddCakeResponse response = service.execute(request);
        response.getNewCake().toString();

    }
}
