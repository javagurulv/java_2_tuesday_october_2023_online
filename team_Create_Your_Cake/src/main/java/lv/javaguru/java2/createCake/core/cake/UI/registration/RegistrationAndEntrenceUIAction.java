package lv.javaguru.java2.createCake.core.cake.UI.registration;

import lv.javaguru.java2.createCake.core.cake.UI.UIAction;

import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.User;

public class RegistrationAndEntrenceUIAction implements UIAction {
    private static RegistrationMethods registrationMethods = new RegistrationMethods();


    @Override
    public void execute() {
       registrationMethods.create();
    }


    @Override
    public void execute(String userLogin) {

    }

    @Override
    public void execute(User user) {

    }



}
