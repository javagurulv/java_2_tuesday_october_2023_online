package lv.javaguru.java2.cakeConstructor.core_user;

import lv.javaguru.java2.cakeConstructor.core_user.UIConsoleUsers.AddUserUIConsole;
import lv.javaguru.java2.cakeConstructor.core_user.UIConsoleUsers.UIConsoleUsers;
import lv.javaguru.java2.cakeConstructor.core_user.database_users.UserDataBase;
import lv.javaguru.java2.cakeConstructor.core_user.database_users.UserUIDataBase;
import lv.javaguru.java2.cakeConstructor.core_user.user_domain.User;

import java.util.Scanner;

public class userApp {
    private static UserUIDataBase dataBase = new UserDataBase();
    private static UIConsoleUsers addUser = new AddUserUIConsole(dataBase);

    public static void main(String[] args) {
        while(true){
            printEntrance();
            int userChoice = getUserChoice();
            User user = registUserLogin(userChoice);
            System.out.println(user);

        }
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
        switch (userChoice){
            case 1: {
                User user1 = new User("dd","ss");
                user=user1;
                break;

            }
            case 2: {
                user = addUser.registr();
            }
        }
        return user;
    }
}
