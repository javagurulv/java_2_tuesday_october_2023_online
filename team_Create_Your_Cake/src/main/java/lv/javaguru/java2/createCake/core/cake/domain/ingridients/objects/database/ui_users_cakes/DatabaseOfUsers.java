package lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.database.ui_users_cakes;

import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.User;
import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.database.AdminList;
import lv.javaguru.java2.createCake.core.cake.services.cakes.AddCakeServiceForUnregistr;

import java.util.ArrayList;
import java.util.List;

public class DatabaseOfUsers implements UIDatabaseClients {
    private static AdminList adminList = new AdminList();

    private static List<User> users = new ArrayList<>();
    public void save(User user) {
        users.add(user);

    }

    private void putAdminList (){
        for (User admin : adminList.listOfAdmin()){
            users.add(admin);
        }
    }

    @Override
    public List<User> getAllUsers() {
        putAdminList();
        return users;
    }
}
