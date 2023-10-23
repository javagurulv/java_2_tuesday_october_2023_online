package lv.javaguru.java2.cakeConstructor.core_user.database_users;

import lv.javaguru.java2.cakeConstructor.core_user.user_domain.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InFileUsersData implements UserUIDataBase {

    private List<User> users = new ArrayList<>();
    private String file;
    public InFileUsersData(){
       this.file = "databases/user_database";
    }
    @Override
    public void addUser(User user) {
        users.add(user);
        saveUser();
    }

    @Override
    public void saveUser() {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        String absolutePath = classLoader.getResource(file).getFile();
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(absolutePath))) {
            oos.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        String absolutePath = classLoader.getResource(file).getFile();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(absolutePath))) {
            users = (List<User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return users;
    }
}
