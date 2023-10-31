package lv.javaguru.java2.createCake.core.cake.domain.ingridients.cases.befor_registration;

import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.Cake;

import java.util.List;
import java.util.Scanner;

public class CaseCheckOrder {

    private static void printOrder(List<Cake> cakeList){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your phone number ");
        String userNameAndPhone = scan.nextLine();
        for (Cake cake:cakeList){
            if ((cake.getUserLogin().equals(userNameAndPhone))&& (cake.getStatus()!=4 || cake.getStatus() != 1)){
                System.out.println(cake);
            }
        }
        System.out.println("The list end.");
    }

}
