package lv.javaguru.java2.cakeConstructor.core.users.users_database;

import lv.javaguru.java2.cakeConstructor.core.cake.domain.Cake;
import lv.javaguru.java2.cakeConstructor.core.users.user_domain.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InFileUsersDatabase implements UsersDatabaseUI{

    private String file;
    public InFileUsersDatabase(){
        this.file="lv/javaguru/java2/cakeConstructor/core/users/users_database/users";
    }
    @Override
    public void add(User user) {
        List<User> users = getAllUsers();
        users.add(user);
        saveUser(users);
    }

    @Override
    public void login(User user) {

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

    @Override
    public void saveUser(List<User> users) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
