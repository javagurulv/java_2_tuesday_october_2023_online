package lv.javaguru.java2.cakeConstructor.core.users.user_services;

import lv.javaguru.java2.cakeConstructor.core.users.request.AddUserResponse;
import lv.javaguru.java2.cakeConstructor.core.users.response.AddUserRequest;
import lv.javaguru.java2.cakeConstructor.core.users.user_domain.User;
import lv.javaguru.java2.cakeConstructor.core.users.users_database.DatabaseUsers;

public class LoginServices {

    private DatabaseUsers users;
    private User user;

    public LoginServices (DatabaseUsers users){
        this.users=users;
    }
    public AddUserResponse execute(AddUserRequest request){
        User user1 = user.login(request.getUserChoice(), request.getLanguage());
        users.add(user1);
        return new AddUserResponse(user1);
    }
}
