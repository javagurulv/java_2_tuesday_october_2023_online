package lv.javaguru.java2.createCake.core.cake.UI.check_order;

import lv.javaguru.java2.createCake.core.cake.UI.UIAction;
import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.User;
import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.database.ui_users_cakes.DatabaseOfCake;
import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.database.ui_users_cakes.UIDatabaseCakes;
import lv.javaguru.java2.createCake.core.cake.request_and_response.check_order.CheckOrderRequest;
import lv.javaguru.java2.createCake.core.cake.request_and_response.check_order.CheckOrderResponse;
import lv.javaguru.java2.createCake.core.cake.services.cakes.CheckOrderService;

import java.util.Scanner;

public class CheckOrderUIAction implements UIAction {
    private static UIDatabaseCakes cakes = new DatabaseOfCake();
    private static CheckOrderService service = new CheckOrderService(cakes);

    @Override
    public void execute(String userLogin) {
        Scanner scan = new Scanner(System.in);
        CheckOrderRequest request = new CheckOrderRequest(userLogin);
        CheckOrderResponse response = service.execute(request);
        System.out.println(response.getCake());
    }

    @Override
    public void execute(User user) {
        Scanner scan = new Scanner(System.in);
        CheckOrderRequest request = new CheckOrderRequest(user.getUserLogin());
        CheckOrderResponse response = service.execute(request);
        System.out.println(response.getCake());
    }

    @Override
    public void execute() {

    }
}
