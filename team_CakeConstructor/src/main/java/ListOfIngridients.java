import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListOfIngridients {

    public List<Biscuit> createListOfBiscuit() {
        List<Biscuit> biscuit = new ArrayList<>();
        biscuit.add(new Biscuit(1, "vanilla", "milk, eggs", 200, 2));
        biscuit.add(new Biscuit(2,"chocolate", "milk, eggs, kakao", 200, 2));
        biscuit.add(new Biscuit(3,"poppy", "milk, eggs, poppy", 200, 2));
        biscuit.add(new Biscuit(4,"french biscuit with berry ", "milk, eggs, berry", 100, 2));
        biscuit.add(new Biscuit(5,"carrot", "milk, eggs", 200, 2));
        biscuit.add(new Biscuit(6,"hot chocolate", "milk, eggs, chocolate", 200, 2));
        return biscuit;
    }

    public void printListOfBiscuit(List<Biscuit> biscuits) {
        for (Biscuit biscuit : biscuits) {
            System.out.println(biscuit);
        }
    }

    public int priceBiscuit(List<Biscuit> biscuits, String  biscuit) {
        int price = 0;
        for (Biscuit biscuit1 : biscuits) {
            if (biscuit1.getTypeOfBiscuit().equals(biscuit)) {
                price = biscuit1.getPrice();
            }
        }
        return price;
    }


    public List<Filling> createListOfFilling() {
        List<Filling> fillings = new ArrayList<>();
        fillings.add(new Filling(1,"kreme strawberry ", "milk, strawberry", 100, 5));
        fillings.add(new Filling(2,"kreme raspberry", "raspberry, milk", 100, 6));
        fillings.add(new Filling(3,"kreme currant", "currant, milk", 100, 5));
        fillings.add(new Filling(4,"kudor lemon", "lemon,milk", 100, 5));
        fillings.add(new Filling(5,"kudor laim", " milk", 100, 5));
        fillings.add(new Filling(6,"kudor orange", "milk, orange", 100, 5));
        fillings.add(new Filling(7,"jelly strawberry", "strawberry", 100, 5));
        fillings.add(new Filling(8,"jelly raspberry", "raspberry", 100, 6));
        fillings.add(new Filling(9,"jelly currant", "currant", 100, 5));
        fillings.add(new Filling(10,"jelly wine", "wine", 100, 9));
        fillings.add(new Filling(11,"cheesecake vanilla ", "milk, eggs", 100, 5));
        fillings.add(new Filling(12,"cheesecake matcha-tea", " milk", 100, 6));
        fillings.add(new Filling(13,"cheesecake chocolate", " chocolate, milk", 100, 5));
        return fillings;
    }

    public void printListOfFilling(List<Filling> fillings) {
        for (Filling filling : fillings) {
            System.out.println(filling);
        }
    }

    public int priceFilling(List<Filling> fillings, String filling) {
        int price = 0;
        for (Filling filling1 : fillings) {
            if (filling1.getTypeOfFilling().equals(filling)) {
                price = filling1.getPrice();
            }
        }
        return price;
    }

    public List<Shell> createListOfShell() {
        List<Shell> shells = new ArrayList<>();
        shells.add(new Shell(1,"cream", "milk, eggs", 100, 6));
        shells.add(new Shell(2,"cream-cheese", "milk", 100, 5));
        shells.add(new Shell(3,"cream-cheese with raspberry", "milk, raspberry", 100, 5));
        shells.add(new Shell(4,"cream-cheese with mango", "milk, mango", 100, 5));
        shells.add(new Shell(5,"cream-cheese with raspberry-strawberry", "milk, raspberry,strawberry", 100, 5));
        shells.add(new Shell(6,"ganache with milk chocolate", "milk, chocolate", 100, 5));
        shells.add(new Shell(7,"ganache with dark chocolate", "milk, chocolate", 100, 5));
        shells.add(new Shell(8,"ganache with liqueur ", "milk, chocolate", 100, 5));
        shells.add(new Shell(9,"strawberry mousse ", "milk, strawberry", 100, 5));
        shells.add(new Shell(10,"raspberry mousse", "milk, raspberry", 100, 5));
        shells.add(new Shell(11,"champagne mousse", "milk", 100, 5));
        shells.add(new Shell(12,"chocolate mousse", "milk, chocolate", 100, 5));
        shells.add(new Shell(13, "mascarpone mousse", "milk", 100, 5));
        return shells;
    }

    public void printListOfShell(List<Shell> shells) {
        for (Shell shell : shells) {
            System.out.println(shell);
        }
    }

    public int priceShell(List<Shell> shells, String shell) {
        int price = 0;
        for (Shell shell1 : shells) {
            if (shell1.getTypeOfShell().equals(shell)) {
                price = shell1.getPrice();
            }
        }
        return price;
    }

    public List<Decor> createListOfDecor() {
        List<Decor> decors = new ArrayList<>();
        decors.add(new Decor(1,"red ganache with dark chocolate", "milk, chocolate", "red", 4));
        decors.add(new Decor(2,"red ganache with white chocolate", "milk, chocolate", "red", 4));
        decors.add(new Decor(3,"red ganache with milk chocolate", "milk, chocolate", "red", 4));
        decors.add(new Decor(4,"blue ganache with dark chocolate", "milk, chocolate", "blue", 4));
        decors.add(new Decor(5,"blue ganache with milk chocolate", "milk, chocolate","blue", 4));
        decors.add(new Decor(6,"blue ganache with white chocolate", "milk, chocolate", "blue", 4));
        decors.add(new Decor(7,"red cream-cheese", "milk", "red", 4));
        decors.add(new Decor(8,"blue cream-cheese", "milk", "blue", 4));
        decors.add(new Decor(9,"red velvet", "milk, chocolate", "red", 8));
        decors.add(new Decor(10,"blue velvet", "milk, chocolate","blue", 8));
        decors.add(new Decor(11,"red mirror glaze", "milk, chocolate","red", 7));
        decors.add(new Decor(12,"blue mirror glaze", "milk, chocolate","blue", 7));
        return decors;
    }

    public void printListOfDecor(List<Decor> decors) {
        for (Decor decor : decors) {
            System.out.println(decor);
        }
    }

    public int priceDecor(List<Decor> decors, String decor) {
        int price = 0;
        for (Decor decor1 : decors) {
            if (decor1.getTypeOfDecor().equals(decor)) {
                price = decor1.getPrice();
            }
        }
        return price;
    }

    public String findBiscuit (List<Biscuit>biscuits, int biscuitId){
        String biscuit=" ";
        for (Biscuit biscuit1:biscuits){
            if (biscuit1.getBiscuitId()==biscuitId){
                biscuit = biscuit1.getTypeOfBiscuit();
            }
        }
        return biscuit;
    }
    public String findFilling (List<Filling> fillings, int fillingId){
        String filling=" ";
        for (Filling filling1:fillings){
            if (filling1.getFillingId()==fillingId){
                filling = filling1.getTypeOfFilling();
            }
        }
        return filling;
    }
    public String findShell (List<Shell> shells, int shellId){
        String shell =" ";
        for (Shell shell1:shells){
            if (shell1.getShellId()==shellId){
                shell=shell1.getTypeOfShell();
            }
        }
        return shell;
    }
    public String findDecor (List<Decor> decors, int decorId){
        String decor =" ";
        for (Decor decor1: decors){
            if (decor1.getDecorId()==decorId){
                decor= decor1.getTypeOfDecor();
            }
        }
        return decor;
    }

    public String biscuit (List<Biscuit>biscuits){
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose a biscuit!");
        printListOfBiscuit(biscuits);
        int biscuitId = scan.nextInt();
        return findBiscuit(biscuits,biscuitId);
    }
    public String filling (List <Filling> fillings){
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose a filling!");
        printListOfFilling(fillings);
        int fillingId = scan.nextInt();
        return findFilling(fillings, fillingId);
    }
    public String shell (List<Shell>shells){
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose a shell!");
        printListOfShell(shells);
        int shellId= scan.nextInt();
        return findShell(shells,shellId);
    }
    public String decor (List <Decor> decors){
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose a decor!");
        printListOfDecor(decors);
        int decorId = scan.nextInt();
        return findDecor(decors,decorId);
    }
    public List<Cake> createCake ( int clientId){
        List<Biscuit> biscuits = createListOfBiscuit();
        List<Filling> fillings = createListOfFilling();
        List<Shell> shells = createListOfShell();
        List<Decor> decors = createListOfDecor();
        List<Cake> cakes = new ArrayList<>();

        String biscuit = biscuit(biscuits);
        int price = priceBiscuit(biscuits, biscuit);

        String filling = filling(fillings);
        price = priceFilling(fillings, filling) + price;

        String shell = shell(shells);
        price = priceShell(shells, shell) + price;

        String decor = decor(decors);
        price = priceDecor(decors, decor) + price;

        Cake cake1 = new Cake(biscuit,filling,shell,decor,clientId,price);

        return cakes;
    }
}


