package lv.javaguru.java2.createCake.core.cake.domain.ingridients.cases.after_registration_user;

import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.Cake;
import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.User;
import java.util.List;
import java.util.Scanner;

public class CasePriviosCakes {
    private static void printOrder(List<Cake> cakeList, User user){
        for (Cake cake:cakeList){
            if (cake.getUserLogin().equals(user.getUserLogin())){
                System.out.println(cake);
            }
        }
        System.out.println("The list end.");
    }
}
