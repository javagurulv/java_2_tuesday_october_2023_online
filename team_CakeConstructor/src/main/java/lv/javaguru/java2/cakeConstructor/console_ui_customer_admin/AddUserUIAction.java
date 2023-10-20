package lv.javaguru.java2.cakeConstructor.console_ui_customer_admin;

import lv.javaguru.java2.cakeConstructor.core.users.user_services.AddUsersService;

public class AddUserUIAction implements UIUserAction {
    private AddUsersService service;
    public AddUserUIAction (AddUsersService service){
        this.service=service;
    }
    @Override
    public void login() {

    }
}
