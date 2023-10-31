package lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects;

import lv.javaguru.java2.createCake.core.cake.domain.ingridients.parts_of_cake.biscuits.Biscuits;
import lv.javaguru.java2.createCake.core.cake.domain.ingridients.parts_of_cake.decors.Decors;
import lv.javaguru.java2.createCake.core.cake.domain.ingridients.parts_of_cake.fillings.Fillings;
import lv.javaguru.java2.createCake.core.cake.domain.ingridients.parts_of_cake.shells.Shells;

import java.util.ArrayList;
import java.util.List;

public class ListOfIngridients {

    public List<Biscuits> createListOfBiscuit() {
        List<Biscuits> biscuit = new ArrayList<>();
        biscuit.add(new Biscuits(1, "vanilla", "milk, eggs",  2));
        biscuit.add(new Biscuits(2,"chocolate", "milk, eggs, kakao",  2));
        biscuit.add(new Biscuits(3,"poppy", "milk, eggs, poppy", 2));
        biscuit.add(new Biscuits(4,"french biscuit with berry ", "milk, eggs, berry",  2));
        biscuit.add(new Biscuits(5,"carrot", "milk, eggs", 2));
        biscuit.add(new Biscuits(6,"hot chocolate", "milk, eggs, chocolate",  2));
        return biscuit;
    }

    public List<Fillings> createListOfFilling() {
        List<Fillings> fillings = new ArrayList<>();
        fillings.add(new Fillings(1,"kreme strawberry ", "milk, strawberry", 5));
        fillings.add(new Fillings(2,"kreme raspberry", "raspberry, milk", 6));
        fillings.add(new Fillings(3,"kreme currant", "currant, milk",  5));
        fillings.add(new Fillings(4,"kudor lemon", "lemon,milk",  5));
        fillings.add(new Fillings(5,"kudor laim", " milk",  5));
        fillings.add(new Fillings(6,"kudor orange", "milk, orange", 5));
        fillings.add(new Fillings(7,"jelly strawberry", "strawberry",  5));
        fillings.add(new Fillings(8,"jelly raspberry", "raspberry", 6));
        fillings.add(new Fillings(9,"jelly currant", "currant",  5));
        fillings.add(new Fillings(10,"jelly wine", "wine", 9));
        fillings.add(new Fillings(11,"cheesecake vanilla ", "milk, eggs", 5));
        fillings.add(new Fillings(12,"cheesecake matcha-tea", " milk", 6));
        fillings.add(new Fillings(13,"cheesecake chocolate", " chocolate, milk", 5));
        return fillings;
    }

    public List<Shells> createListOfShell() {
        List<Shells> shells = new ArrayList<>();
        shells.add(new Shells(1,"cream", "milk, eggs", 6));
        shells.add(new Shells(2,"cream-cheese", "milk", 5));
        shells.add(new Shells(3,"cream-cheese with raspberry", "milk, raspberry", 5));
        shells.add(new Shells(4,"cream-cheese with mango", "milk, mango", 5));
        shells.add(new Shells(5,"cream-cheese with raspberry-strawberry", "milk, raspberry,strawberry", 5));
        shells.add(new Shells(6,"ganache with milk chocolate", "milk, chocolate",  5));
        shells.add(new Shells(7,"ganache with dark chocolate", "milk, chocolate", 5));
        shells.add(new Shells(8,"ganache with liqueur ", "milk, chocolate", 5));
        shells.add(new Shells(9,"strawberry mousse ", "milk, strawberry", 5));
        shells.add(new Shells(10,"raspberry mousse", "milk, raspberry", 5));
        shells.add(new Shells(11,"champagne mousse", "milk",  5));
        shells.add(new Shells(12,"chocolate mousse", "milk, chocolate", 5));
        shells.add(new Shells(13, "mascarpone mousse", "milk", 5));
        return shells;
    }

    public List<Decors> createListOfDecor() {
        List<Decors> decors = new ArrayList<>();
        decors.add(new Decors(1,"ganache with dark chocolate", " ", 4));
        decors.add(new Decors(2,"ganache with white chocolate", " ", 4));
        decors.add(new Decors(3,"ganache with milk chocolate", " ",  4));
        decors.add(new Decors(7,"cream-cheese", " ", 4));
        decors.add(new Decors(9,"velvet", " ",  8));
        decors.add(new Decors(11,"mirror glaze", " ",7));
        decors.add(new Decors(12,"double-colour mirror glaze", " ",7));
        return decors;
    }
}
