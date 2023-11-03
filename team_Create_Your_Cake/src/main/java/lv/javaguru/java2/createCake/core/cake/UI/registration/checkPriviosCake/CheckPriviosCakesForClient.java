package lv.javaguru.java2.createCake.core.cake.UI.registration.checkPriviosCake;

import lv.javaguru.java2.createCake.core.cake.UI.UIAction;
import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.Cake;
import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.User;
import lv.javaguru.java2.createCake.core.cake.request_and_response.check_privios_cakes.CheckPriviosCakesForClientRequest;
import lv.javaguru.java2.createCake.core.cake.request_and_response.check_privios_cakes.CheckPriviosCakesForClientResponse;
import lv.javaguru.java2.createCake.core.cake.services.cakes.CheckOrderService;
import lv.javaguru.java2.createCake.core.cake.services.users.CheckPriviosCakesService;

import java.util.Scanner;


public class CheckPriviosCakesForClient implements UIAction {
    private static CheckPriviosCakesService service;

    @Override
    public void execute(String userLogin) {

    }

    @Override
    public void execute(User user) {
        Scanner scan = new Scanner(System.in);
        CheckPriviosCakesForClientRequest request = new CheckPriviosCakesForClientRequest(user.getUserLogin());
        CheckPriviosCakesForClientResponse response = service.execute(request);
        for (Cake cake : response.getCakes()) {
                System.out.println(cake);
        }
    }

    @Override
    public void execute() {

    }
}
