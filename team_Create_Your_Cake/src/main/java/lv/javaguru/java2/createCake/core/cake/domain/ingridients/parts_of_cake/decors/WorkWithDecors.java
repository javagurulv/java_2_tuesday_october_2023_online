package lv.javaguru.java2.createCake.core.cake.domain.ingridients.parts_of_cake.decors;

import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.WorkWithIngridients;

import java.util.List;
import java.util.Scanner;

public class WorkWithDecors {

    public WorkWithIngridients work = new WorkWithIngridients();

    public String findDecor (List<Decors> decors, int decorId){
        String decor =null;
        for (Decors decor1: decors){
            if (decor1.getDecorId()==decorId){
                decor= decor1.getTypeOfDecor();
                break;
            }
        }
        return decor;
    }


    public String decor(List<Decors> decors) {
        Scanner scan = new Scanner(System.in);
        String choseniDecor = null;

        while (choseniDecor== null) {
            try {
                System.out.println("Choose a fillings! Please enter a fillings ID.");
                work.printListOfDecor(decors);
                int shellsid = scan.nextInt();
                scan.nextLine();

                choseniDecor = findDecor(   decors, shellsid);

                if (choseniDecor == null) {
                    System.out.println("Invalid fillings ID. Please choose a valid biscuit ID.");
                }
            } catch (java.util.InputMismatchException exception) {
                System.out.println("Invalid input. Please enter a valid fillings ID.");
                scan.nextLine();
            }
        }

        return choseniDecor;
    }
}
