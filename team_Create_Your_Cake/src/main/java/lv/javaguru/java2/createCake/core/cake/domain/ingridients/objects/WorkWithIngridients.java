package lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects;

import lv.javaguru.java2.createCake.core.cake.domain.ingridients.parts_of_cake.biscuits.Biscuits;
import lv.javaguru.java2.createCake.core.cake.domain.ingridients.parts_of_cake.decors.Decors;
import lv.javaguru.java2.createCake.core.cake.domain.ingridients.parts_of_cake.fillings.Fillings;
import lv.javaguru.java2.createCake.core.cake.domain.ingridients.parts_of_cake.shells.Shells;

import java.util.List;

public class WorkWithIngridients {

    public void printListOfBiscuit(List<Biscuits> biscuits) {
        for (Biscuits biscuit : biscuits) {
            System.out.println(biscuit);
        }
    }

    public int priceBiscuit(List<Biscuits> biscuits, String  biscuit) {
        int price = 0;
        for (Biscuits biscuit1 : biscuits) {
            if (biscuit1.getTypeOfBiscuit().equals(biscuit)) {
                price = biscuit1.getPrice();
            }
        }
        return price;
    }

    public void printListOfFilling(List<Fillings> fillings) {
        for (Fillings filling : fillings) {
            System.out.println(filling);
        }
    }

    public int priceFilling(List<Fillings> fillings, String filling) {
        int price = 0;
        for (Fillings filling1 : fillings) {
            if (filling1.getFillingType().equals(filling)) {
                price = filling1.getPrice();
            }
        }
        return price;
    }

    public void printListOfShell(List<Shells> shells) {
        for (Shells shell : shells) {
            System.out.println(shell);
        }
    }

    public int priceShell(List<Shells> shells, String shell) {
        int price = 0;
        for (Shells shell1 : shells) {
            if (shell1.getTypeOfShell().equals(shell)) {
                price = shell1.getPrice();
            }
        }
        return price;
    }
    public void printListOfDecor(List<Decors> decors) {
        for (Decors decor : decors) {
            System.out.println(decor);
        }
    }

    public int priceDecor(List<Decors> decors, String decor) {
        int price = 0;
        for (Decors decor1 : decors) {
            if (decor1.getTypeOfDecor().equals(decor)) {
                price = decor1.getPrice();
            }
        }
        return price;
    }
}
