package lv.javaguru.java2.cakeConstructor.privious.cake.responses;

import lv.javaguru.java2.cakeConstructor.privious.core_user.user_domain.User;

import java.util.List;

public class SearchUserResponse extends CoreResponse{

    private List<User> users;

    public SearchUserResponse(List<User> users, List<CoreError> errors) {
        super(errors);
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }
}

