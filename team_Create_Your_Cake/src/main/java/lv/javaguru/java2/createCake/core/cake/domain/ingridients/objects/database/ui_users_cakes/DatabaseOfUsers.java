package lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.database.ui_users_cakes;

import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.User;

import java.util.ArrayList;
import java.util.List;

public class DatabaseOfUsers implements UIDatabaseClients {

    private static List<User> users = new ArrayList<>();

    @Override
    public void save(User user) {
        users.add(user);

    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }
}
