package lv.javaguru.java2.cakeConstructor.core_user.database_users;

import lv.javaguru.java2.cakeConstructor.core_user.user_domain.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InFileUsersData implements UserUIDataBase {

    private List<User> users = new ArrayList<>();
    private String file;
    public InFileUsersData(){
       this.file = "C:\\Users\\ArchAtalar\\javaLab\\java_2_tuesday_october_2023_online\\team_CakeConstructor\\src\\main\\java\\lv\\javaguru\\java2\\cakeConstructor\\core_user\\database_users\\user_database";
    }
    @Override
    public void addUser(User user) {
        List <User> users = getAllUsers();
        users.add(user);
        saveUser(users);
    }

    @Override
    public void saveUser(List<User> user) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
