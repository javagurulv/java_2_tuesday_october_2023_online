package lv.javaguru.java2.createCake.core.cake.domain.ingridients.cases.befor_registration;

import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.Cake;
import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.CreateCakeProcess;
import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.User;

import java.util.Scanner;

public class CaseCreateCake {

    private static CreateCakeProcess process = new CreateCakeProcess();

    public static void createCakeforUnregistrateUser(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your phone number - ");
        String userPhone = scan.nextLine();
        Cake cake = process.createCakeForNotRegistrate(userPhone);


    }
    public static void createCakeforRegistrateUser(User user){
        Cake cake = process.createCakeForNotRegistrate(user.getUserLogin());
    }


}
