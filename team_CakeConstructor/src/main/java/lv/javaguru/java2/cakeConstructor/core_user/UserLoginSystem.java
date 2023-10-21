package lv.javaguru.java2.cakeConstructor.core_user;

import lv.javaguru.java2.cakeConstructor.core_user.UIConsoleUsers.AddUserUIConsole;
import lv.javaguru.java2.cakeConstructor.core_user.UIConsoleUsers.RegistarUserUIConsole;
import lv.javaguru.java2.cakeConstructor.core_user.UIConsoleUsers.UIConsoleUsers;
import lv.javaguru.java2.cakeConstructor.core_user.database_users.UserDataBase;
import lv.javaguru.java2.cakeConstructor.core_user.database_users.UserUIDataBase;
import lv.javaguru.java2.cakeConstructor.core_user.user_domain.User;

import java.util.Scanner;

public class UserLoginSystem implements SystemUserLogin {
    private static UserUIDataBase dataBase = new UserDataBase();
    private static UIConsoleUsers addUser = new AddUserUIConsole(dataBase);
    private static UIConsoleUsers register = new RegistarUserUIConsole(dataBase);

    public User login() {
            printEntrance();
            int userChoice = getUserChoice();
            User user = registUserLogin(userChoice);
            return user;
    }
    private static void printEntrance() {
        System.out.println();
        System.out.println("Do you have account?");
        System.out.println("1. - Yes ");
        System.out.println("2. No");
        System.out.println();
    }

    private static int getUserChoice() {
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }
    private static User  registUserLogin(int userChoice){
        User user = null;
         if (userChoice == 2){
                user = addUser.registr();
            } else {
                user = register.registr();
         }
        return user;
    }
}
