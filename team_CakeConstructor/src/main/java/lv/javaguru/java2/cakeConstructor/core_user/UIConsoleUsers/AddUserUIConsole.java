package lv.javaguru.java2.cakeConstructor.core_user.UIConsoleUsers;

import lv.javaguru.java2.cakeConstructor.core_user.database_users.UserUIDataBase;
import lv.javaguru.java2.cakeConstructor.core_user.user_domain.User;
import lv.javaguru.java2.cakeConstructor.core_user.database_users.UserDataBase;

import java.util.Scanner;

public class AddUserUIConsole implements UIConsoleUsers {
    private UserUIDataBase userDataBase;
    public AddUserUIConsole(UserUIDataBase userDataBase){
        this.userDataBase=userDataBase;
    }


    @Override
    public User registr() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please create your login !");
        String userLogin = scan.nextLine();
        System.out.println("Please create your password !");
        String userPassword = scan.nextLine();
        System.out.println("Please enter you first name !");
        String userName = scan.nextLine();
        System.out.println("Please enter your last name !");
        String userSurname = scan.nextLine();
        System.out.println("Please enter your email !");
        String userEmail = scan.nextLine();
        User user = new User(userLogin,userPassword,userName,userSurname,userEmail);
        userDataBase.saveUser(user);
        System.out.println("Welcome " + user.getUserName());
        return new User(user.getUserLogin(), user.getUserPassword());
    }
}
