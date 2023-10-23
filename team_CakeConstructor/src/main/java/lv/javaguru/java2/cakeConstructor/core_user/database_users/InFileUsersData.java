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
        String absolutePath = "C:\\Users\\ArchAtalar\\javaLab\\java_2_tuesday_october_2023_online\\team_CakeConstructor\\src\\main\\resources\\databases\\user_database";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(absolutePath))) {
            oos.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        String absolutePath = "C:\\Users\\ArchAtalar\\javaLab\\java_2_tuesday_october_2023_online\\team_CakeConstructor\\src\\main\\resources\\databases\\user_database";
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(absolutePath))) {
            users = (List<User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return users;
    }
}
