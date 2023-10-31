package lv.javaguru.java2.createCake.core.cake.domain.ingridients.parts_of_cake.fillings;

import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.WorkWithIngridients;

import java.util.List;
import java.util.Scanner;

public class WorkWithFillings {

    private WorkWithIngridients work = new WorkWithIngridients();

    public String filling(List<Fillings> fillings) {
        Scanner scan = new Scanner(System.in);
        String choseniFlling = null;

        while (choseniFlling == null) {
            try {
                System.out.println("Choose a fillings! Please enter a fillings ID.");
                work.printListOfFilling(fillings);
                int fillingsid = scan.nextInt();
                scan.nextLine();

                choseniFlling = findFilling(fillings, fillingsid);

                if (choseniFlling == null) {
                    System.out.println("Invalid fillings ID. Please choose a valid biscuit ID.");
                }
            } catch (java.util.InputMismatchException exception) {
                System.out.println("Invalid input. Please enter a valid fillings ID.");
                scan.nextLine();
            }
        }

        return choseniFlling;
    }
    public String findFilling (List<Fillings> fillings, int fillingId){
        String filling=null;
        for (Fillings filling1:fillings){
            if (filling1.getFillingId()==fillingId){
                filling = filling1.getFillingType();
                break;
            }
        }
        return filling;
    }
}
