package lv.javaguru.java2.createCake.core.cake.domain.ingridients.cases.befor_registration;

import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.database.AdminList;
import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.User;
import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.database.ui_users_cakes.DatabaseOfUsers;
import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.database.ui_users_cakes.UIDatabaseClients;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CaseRegistration {
    private static Scanner scan = new Scanner(System.in);
    private static UIDatabaseClients users = new DatabaseOfUsers();
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
        Date birthday = dateUser();
        System.out.println("Please enter your phone number ");
        int number = scan.nextInt();
        System.out.println("Please enter your e-mail ");
        String userEmail = scan.next();
        System.out.println("Please enter your adress ");
        String adress = scan.nextLine();
        System.out.println("Please choose - Do you want to recieve at home? ");
        String userDelivery = scan.nextLine();
        User newUser = new User(login,password,userName,userSurname,birthday,number,userEmail,adress,userDelivery);
        users.save(newUser);
        return newUser;

    }

    private static Date dateUser(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter your Birthday (yyyy-MM-dd):");
        String userInput = scan.nextLine();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = null;

        try {
            birthday = dateFormat.parse(userInput);
            System.out.println("Your birthday is: " + dateFormat.format(birthday));
        } catch (ParseException e) {
            System.err.println("Invalid date format. Please enter your birthday in yyyy-MM-dd format.");
        }
        return birthday;
    }

    public static User registrUser(){
      System.out.println("Please enter your login ");
      String login = scan.nextLine();
      System.out.println("Please enter your password ");
      String password = scan.nextLine();
      User user = findUser(login,password);
      user.setStatusOfClient(checkAdmin(user.getUserLogin()));
      return user;
    }

    private static int checkAdmin(String login){
        AdminList list = new AdminList();
        List<User> admins = list.listOfAdmin();
        int status = 1;
        for (User admin : admins){
            if (login.equals(admin.getUserLogin())){
                status = 0;
            }
        }
        return status;
    }

    private static User findUser (String login, String password){
        User findUser = null;
        for (User user : users.getAllUsers())
            if (user.getUserLogin().equals(login) && user.getPassword().equals(password)) {
                System.out.println("Welcome!" + user.getUserName());
                findUser = user;
            } else {
                System.out.println("Please check your login and password!");
            }
        return findUser;
    }

}
