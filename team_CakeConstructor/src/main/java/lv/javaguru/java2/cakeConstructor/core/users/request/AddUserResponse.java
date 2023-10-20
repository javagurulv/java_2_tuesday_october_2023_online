package lv.javaguru.java2.cakeConstructor.core.users.request;

import lv.javaguru.java2.cakeConstructor.core.users.user_domain.User;

public class AddUserResponse {

    private User user;


    public AddUserResponse (User user){
        this.user=user;
    }
    public User getUser() {
        return user;
    }

}
