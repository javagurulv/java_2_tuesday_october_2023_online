package lv.javaguru.java2.cakeConstructor.core.users.users_database;

import lv.javaguru.java2.cakeConstructor.core.users.user_domain.User;

import java.util.List;

public interface UsersDatabaseUI {
    void add(User user);

    void login(User user);
    List<User> getAllUsers();
    void saveUser (List<User> users);

}
