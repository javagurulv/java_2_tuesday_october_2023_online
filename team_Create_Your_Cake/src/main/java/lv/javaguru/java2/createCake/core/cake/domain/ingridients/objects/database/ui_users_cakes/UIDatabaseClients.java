package lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.database.ui_users_cakes;

import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.User;

import java.util.List;

public interface UIDatabaseClients {

    void save(User user);
    List<User> getAllUsers();
}
