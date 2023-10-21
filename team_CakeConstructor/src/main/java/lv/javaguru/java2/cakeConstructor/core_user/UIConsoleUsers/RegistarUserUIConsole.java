package lv.javaguru.java2.cakeConstructor.core_user.UIConsoleUsers;

import lv.javaguru.java2.cakeConstructor.core_user.database_users.UserDataBase;
import lv.javaguru.java2.cakeConstructor.core_user.database_users.UserUIDataBase;
import lv.javaguru.java2.cakeConstructor.core_user.user_domain.User;

import java.util.List;
import java.util.Scanner;

public class RegistarUserUIConsole implements UIConsoleUsers {
    private UserUIDataBase dataBase;
    public RegistarUserUIConsole (UserUIDataBase dataBase){
        this.dataBase=dataBase;
    }
    @Override
    public User registr() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your login!");
        String userLogin = scan.nextLine();
        System.out.println("Please enter your password!");
        String userPassword= scan.nextLine();
        User user = allowedLogin(userLogin,userPassword);
        return user;


    }

    private boolean check (User newUser){
        List<User> users = dataBase.getAllUsers();
        boolean isUser = false;
        for (User user : users){
            if (newUser.getUserLogin()==user.getUserLogin() && newUser.getUserPassword() ==user.getUserPassword()){
                isUser=true;
            } else {
                System.out.println("Please check your login and password!");
            }
        }
        return isUser;
    }

    private User allowedLogin (String userLogin, String userPassword){
        User user = new User(userLogin,userPassword);
        User userAllow = null;
        boolean check = check(user);
        if (check == true){
            userAllow = user;
        }
        return userAllow;
    }
}
