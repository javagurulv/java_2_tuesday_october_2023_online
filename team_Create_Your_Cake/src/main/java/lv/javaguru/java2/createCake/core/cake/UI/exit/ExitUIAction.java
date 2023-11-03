package lv.javaguru.java2.createCake.core.cake.UI.exit;

import lv.javaguru.java2.createCake.core.cake.UI.UIAction;
import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.User;

public class ExitUIAction implements UIAction {

    @Override
    public void execute(String userLogin) {

    }

    @Override
    public void execute(User user) {

    }

    @Override
    public void execute() {
        System.out.println("Thank you for being with us!");
        System.exit(0);
    }
}
