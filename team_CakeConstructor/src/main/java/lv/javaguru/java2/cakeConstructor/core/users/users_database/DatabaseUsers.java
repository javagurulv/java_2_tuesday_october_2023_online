package lv.javaguru.java2.cakeConstructor.core.users.users_database;

import lv.javaguru.java2.cakeConstructor.core.users.user_domain.User;

import java.util.ArrayList;
import java.util.List;

public class DatabaseUsers implements UsersDatabaseUI{
    private List <User> users = new ArrayList<>();
    private Long nextId = 1L;


    @Override
    public void add(User user) {
        users.add(user);
    }

    @Override
    public void login(User user) {

    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public void saveUser(List<User> users) {

    }

}
