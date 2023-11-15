package lv.javaguru.java2.cakeConstructor.privious.core_user.database_users;

import lv.javaguru.java2.cakeConstructor.privious.core_user.user_domain.User;

import java.util.ArrayList;
import java.util.List;

public class UserDataBase implements UserUIDataBase {
    private List<User> users = new ArrayList<>();

    @Override
    public void addUser(User user) {
        user.setUserLogin(user.getUserLogin());
        user.setUserPassword(user.getUserPassword());
        users.add(user);
    }

    @Override
    public void saveUser() {

    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }
}
