package lv.javaguru.java2.createCake.core.cake.domain.ingridients.cases.befor_registration;

import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.database.AdminList;
import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.User;

import java.util.*;

public class CaseRegistration {
    private static Scanner scan = new Scanner(System.in);
    private static List<User> users = new ArrayList<>();
    public static User createNewUser (){

        System.out.println("Welcome!");
        System.out.println("Please create your login ");
        String login = scan.nextLine();
        System.out.println("Please create your password ");
        String password = scan.nextLine();
        System.out.println("Please enter your name ");
        String userName = scan.nextLine();
        System.out.println("Please enter your surname ");
        String userSurname = scan.nextLine();
        System.out.println("Please enter your Birthday ");
        Date birthday = new Date( scan.nextLine());
        System.out.println("Please enter your phone number ");
        int number = scan.nextInt();
        System.out.println("Please enter your e-mail ");
        String userEmail = scan.nextLine();
        System.out.println("Please enter your adress ");
        String adress = scan.nextLine();
        System.out.println("Please choose - Do you want to recieve at home? ");
        String userDelivery = scan.nextLine();
        User newUser = new User(login,password,userName,userSurname,birthday,number,userEmail,adress,userDelivery);
        return newUser;

    }

    public static User registrUser(){
      System.out.println("Please enter your login ");
      String login = scan.nextLine();
      System.out.println("Please enter your password ");
      String password = scan.nextLine();
      User user = user(login,password);
      user.setStatusOfClient(checkAdmin(user.getUserLogin()));
      return user;
    }

    private static int checkAdmin(String login){
        AdminList list = new AdminList();
        List<User> admins = list.listOfAdmin();
        int status = 0;
        for (User admin : admins){
            if (login.equals(admin.getUserLogin())){
                status = 1;
            }
        }
        return status;
    }

    private static User user (String login, String password){
        User findUser = null;
        for (User user : users){
            if (user.getUserLogin().equals(login)&& user.getPassword().equals(password)){
                System.out.println("Welcome!"+ user.getUserName());
               findUser = user;
            } else {
                System.out.println("Please check your login and password!");
            }
        }
        return findUser;
    }

}
