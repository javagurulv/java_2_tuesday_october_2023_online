package lv.javaguru.java2.cakeConstructor.core_user.database_users;

import lv.javaguru.java2.cakeConstructor.core_user.user_domain.User;

import java.util.List;

public interface UserUIDataBase {
    void addUser(User user);

    void saveUser();

    List<User> getAllUsers();

}
