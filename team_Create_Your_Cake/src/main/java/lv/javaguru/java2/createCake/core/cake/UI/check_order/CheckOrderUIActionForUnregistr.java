package lv.javaguru.java2.createCake.core.cake.UI.check_order;

import lv.javaguru.java2.createCake.core.cake.UI.UIAction;
import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.User;

import java.util.Scanner;

public class CheckOrderUIActionForUnregistr implements UIAction {

    private UIAction check = new CheckOrderUIAction();
    @Override
    public void execute(String userLogin) {

    }

    @Override
    public void execute(User user) {

    }

    @Override
    public void execute() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your phone number");
        String userLogin = scan.nextLine();
        check.execute(userLogin);
    }
}
