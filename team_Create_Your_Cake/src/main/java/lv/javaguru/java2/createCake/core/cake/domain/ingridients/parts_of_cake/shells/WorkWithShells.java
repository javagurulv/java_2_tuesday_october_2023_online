package lv.javaguru.java2.createCake.core.cake.domain.ingridients.parts_of_cake.shells;

import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.WorkWithIngridients;

import java.util.List;
import java.util.Scanner;

public class WorkWithShells {

    private WorkWithIngridients work = new WorkWithIngridients();

    public String findShell (List<Shells> shells, int shellId){
        String shell =null;
        for (Shells shell1:shells){
            if (shell1.getShellId()==shellId){
                shell=shell1.getTypeOfShell();
                break;
            }
        }
        return shell;
    }

    public String shell(List<Shells> shells) {
        Scanner scan = new Scanner(System.in);
        String choseniShell = null;

        while (choseniShell== null) {
            try {
                System.out.println("Choose a fillings! Please enter a fillings ID.");
                work.printListOfShell(shells);
                int shellsid = scan.nextInt();
                scan.nextLine();

                choseniShell = findShell(shells, shellsid);

                if (choseniShell == null) {
                    System.out.println("Invalid fillings ID. Please choose a valid biscuit ID.");
                }
            } catch (java.util.InputMismatchException exception) {
                System.out.println("Invalid input. Please enter a valid fillings ID.");
                scan.nextLine();
            }
        }

        return choseniShell;
    }
}
