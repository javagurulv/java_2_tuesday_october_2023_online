package lv.javaguru.java2.cakeConstructor.core.users.user_services;

import lv.javaguru.java2.cakeConstructor.core.users.request.AddUserResponse;
import lv.javaguru.java2.cakeConstructor.core.users.response.AddUserRequest;
import lv.javaguru.java2.cakeConstructor.core.users.user_domain.User;

import lv.javaguru.java2.cakeConstructor.core.users.users_database.DatabaseUsers;

public class AddUsersService {
    private DatabaseUsers databaseUsers;
    private User user;

    public AddUsersService (DatabaseUsers databaseUsers){
        this.databaseUsers=databaseUsers;
    }

    public AddUserResponse execute(AddUserRequest request){
        User user1 = user.createNewUser(request.getUserChoice(), request.getLanguage());
        databaseUsers.add(user1);
        return new AddUserResponse(user1);
    }


}
