package lv.javaguru.java2.createCake.core.cake.UI.registration;

import lv.javaguru.java2.createCake.core.cake.UI.UIAction;
import lv.javaguru.java2.createCake.core.cake.UI.add_cake.AddCakeUIActionForRegist;
import lv.javaguru.java2.createCake.core.cake.UI.check_order.CheckOrderUIAction;
import lv.javaguru.java2.createCake.core.cake.UI.registration.checkPriviosCake.CheckPriviosCakesForClient;
import lv.javaguru.java2.createCake.core.cake.UI.exit.ExitUIAction;
import lv.javaguru.java2.createCake.core.cake.domain.ingridients.cases.befor_registration.CaseRegistration;
import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.Cake;
import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.User;
import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.database.ui_users_cakes.DatabaseOfCake;
import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.database.ui_users_cakes.DatabaseOfUsers;
import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.database.ui_users_cakes.UIDatabaseCakes;
import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.database.ui_users_cakes.UIDatabaseClients;
import lv.javaguru.java2.createCake.core.cake.request_and_response.add_cake.AddCakeValidation;
import lv.javaguru.java2.createCake.core.cake.services.users.AddCakeServiceForRegistr;

import java.util.Scanner;

public class RegistrationMethods {

    private static CaseRegistration registration = new CaseRegistration() ;
    private static Scanner scan = new Scanner(System.in);
    private static UIDatabaseCakes cakes = new DatabaseOfCake();
    private static UIDatabaseClients users = new DatabaseOfUsers();
    private static AddCakeValidation validation = new AddCakeValidation();
    private AddCakeServiceForRegistr serviceForRegistn = new AddCakeServiceForRegistr(cakes,validation);
    private UIAction addCake = new AddCakeUIActionForRegist(serviceForRegistn);
    private UIAction checkPriviosCakes = new CheckPriviosCakesForClient();
    private UIAction checkOrder = new CheckOrderUIAction();
    private UIAction exit = new ExitUIAction();




    private User userReg (){
        System.out.println("If you have an account press 1");
        int choice = scan.nextInt();
        User user = null;
        if (choice==1) {
            user = registration.registrUser();
        } else {
            user = registration.createNewUser();
        }
        return user;
    }

    private static void printMenuAfterRegistrationClient (User client){
        System.out.println("Welcome " + client.getUserName());
        System.out.println("Press 1 - create cake!");
        System.out.println("Press 2 - check order");
        System.out.println("Press 3 - privies order ");
        System.out.println("Press 4 - Exit");
    }

    public void create(){
        User user = userReg();
        System.out.println(user.getStatusOfClient());
        if (user==null){
            System.out.println("Check your login and password!");
        } else if (user.getStatusOfClient()==1){
            applicatoinForRegistrUser(user);
        } else if (user.getStatusOfClient()==0){
             applicationForAdmin(user);
        }
    }

    private void applicatoinForRegistrUser (User user){
        printMenuAfterRegistrationClient(user);
        int userChoice= scan.nextInt();
        switch (userChoice){
            case 1: {
                addCake.execute(user);
                break;
            }
            case 2:{
                checkOrder.execute(user);
                break;
            }
            case 3:{
                checkPriviosCakes.execute();
                break;
            }
            case 4:{
                exit.execute();
            }

        }

    }

    private void applicationForAdmin(User user){
        while(true) {
            printMenuAfterRegistrationAdmin(user);
            int userChoice = scan.nextInt();
            switch (userChoice) {
                case 1: {
                   printAllUsers();
                    break;
                }
                case 2: {
                   for (Cake cake: cakes.getAllCakes()){
                       System.out.println(cake);
                   }
                }
                case 4: {
                    exit.execute();
                }
            }
        }



    }

    private static void printMenuAfterRegistrationAdmin (User admin){
        System.out.println("Welcome " + admin.getUserName());
        System.out.println("Press 1 - clients");
        System.out.println("Press 2 - list of order");
        System.out.println("Press 3 - Statistics");
        System.out.println("Press 4 - Exit");
    }

    private void printAllUsers(){
        for (User user1 : users.getAllUsers()) {
            System.out.println(user1);
        }

    }

}
