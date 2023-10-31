package lv.javaguru.java2.createCake.core.cake.domain.ingridients.parts_of_cake.biscuits;

import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.WorkWithIngridients;
import lv.javaguru.java2.createCake.core.cake.domain.ingridients.parts_of_cake.biscuits.Biscuits;

import java.util.List;
import java.util.Scanner;

public class WorkWithBiscuits {

    private WorkWithIngridients work = new WorkWithIngridients();
    public String findBiscuit(List<Biscuits> biscuits, int biscuitId) {
        String biscuit = null;
        for (Biscuits biscuit1 : biscuits) {
            if (biscuit1.getBiscuitNumber() == biscuitId) {
                biscuit = biscuit1.getTypeOfBiscuit();
                break;
            }
        }
        return biscuit;
    }

    public String biscuit(List<Biscuits> biscuits) {
        Scanner scan = new Scanner(System.in);
        String chosenBiscuit = null;

        while (chosenBiscuit == null) {
            try {
                System.out.println("Choose a biscuit! Please enter a biscuit ID.");
                work.printListOfBiscuit(biscuits);
                int biscuitId = scan.nextInt();
                scan.nextLine();

                chosenBiscuit = findBiscuit(biscuits, biscuitId);

                if (chosenBiscuit == null) {
                    System.out.println("Invalid biscuit ID. Please choose a valid biscuit ID.");
                }
            } catch (java.util.InputMismatchException exception) {
                System.out.println("Invalid input. Please enter a valid biscuit ID.");
                scan.nextLine();
            }
        }

        return chosenBiscuit;
    }
}
