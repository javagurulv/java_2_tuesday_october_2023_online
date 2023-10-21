package lv.javaguru.java2.cakeConstructor.core_user.database_users;

import lv.javaguru.java2.cakeConstructor.core_user.user_domain.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InFileUsersData implements UserUIDataBase {

    private String file;
    public InFileUsersData(){
        this.file= "lv/javaguru/java2/cakeConstructor/core_user/database_users/user_data";
    }
    @Override
    public void addUser(User user) {
        List <User> users = getAllUsers();
        users.add(user);
        saveUser(user);
    }

    @Override
    public void saveUser(User user) {
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            users = (List<User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return users;
    }
}
