import java.util.ArrayList;
import java.util.List;

public class ListOfIngridients {

    public List<Biscuit> createListOfBiscuit() {
        List<Biscuit> biscuit = new ArrayList<>();
        biscuit.add(new Biscuit("vanilla", "milk, eggs", 200, 2));
        biscuit.add(new Biscuit("chocolate", "milk, eggs, kakao", 200, 2));
        biscuit.add(new Biscuit("poppy", "milk, eggs, poppy", 200, 2));
        biscuit.add(new Biscuit("french biscuit with berry ", "milk, eggs, berry", 100, 2));
        biscuit.add(new Biscuit("carrot", "milk, eggs", 200, 2));
        biscuit.add(new Biscuit("hot chocolate", "milk, eggs, chocolate", 200, 2));
        return biscuit;
    }

    public void printListOfBiscuit(List<Biscuit> biscuits) {
        for (Biscuit biscuit : biscuits) {
            System.out.println(biscuit);
        }
    }

    public int priceBiscuit(List<Biscuit> biscuits, String biscuit) {
        int price = 0;
        for (Biscuit biscuit1 : biscuits) {
            if (biscuit1.getTypeOfBiscuit() == biscuit) {
                price = biscuit1.getPrice();
            }
        }
        return price;
    }


    public List<Filling> createListOfFilling() {
        List<Filling> fillings = new ArrayList<>();
        fillings.add(new Filling("kreme strawberry ", "milk, strawberry", 100, 5));
        fillings.add(new Filling("kreme raspberry", "raspberry, milk", 100, 6));
        fillings.add(new Filling("kreme currant", "currant, milk", 100, 5));
        fillings.add(new Filling("kudor lemon", "lemon,milk", 100, 5));
        fillings.add(new Filling("kudor laim", " milk", 100, 5));
        fillings.add(new Filling("kudor orange", "milk, orange", 100, 5));
        fillings.add(new Filling("jelly strawberry", "strawberry", 100, 5));
        fillings.add(new Filling("jelly raspberry", "raspberry", 100, 6));
        fillings.add(new Filling("jelly currant", "currant", 100, 5));
        fillings.add(new Filling("jelly wine", "wine", 100, 9));
        fillings.add(new Filling("cheesecake vanilla ", "milk, eggs", 100, 5));
        fillings.add(new Filling("cheesecake matcha-tea", " milk", 100, 6));
        fillings.add(new Filling("cheesecake chocolate", " chocolate, milk", 100, 5));
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
            if (filling1.getTypeOfFilling() == filling) {
                price = filling1.getPrice();
            }
        }
        return price;
    }

    public List<Shell> createListOfShell() {
        List<Shell> shells = new ArrayList<>();
        shells.add(new Shell("cream", "milk, eggs", 100, 6));
        shells.add(new Shell("cream-cheese", "milk", 100, 5));
        shells.add(new Shell("cream-cheese with raspberry", "milk, raspberry", 100, 5));
        shells.add(new Shell("cream-cheese with mango", "milk, mango", 100, 5));
        shells.add(new Shell("cream-cheese with raspberry-strawberry", "milk, raspberry,strawberry", 100, 5));
        shells.add(new Shell("ganache with milk chocolate", "milk, chocolate", 100, 5));
        shells.add(new Shell("ganache with dark chocolate", "milk, chocolate", 100, 5));
        shells.add(new Shell("ganache with liqueur ", "milk, chocolate", 100, 5));
        shells.add(new Shell("strawberry mousse ", "milk, strawberry", 100, 5));
        shells.add(new Shell("raspberry mousse", "milk, raspberry", 100, 5));
        shells.add(new Shell("champagne mousse", "milk", 100, 5));
        shells.add(new Shell("chocolate mousse", "milk, chocolate", 100, 5));
        shells.add(new Shell("mascarpone mousse", "milk", 100, 5));
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
            if (shell1.getTypeOfShell() == shell) {
                price = shell1.getPrice();
            }
        }
        return price;
    }

    public List<Decor> createListOfDecor() {
        List<Decor> decors = new ArrayList<>();
        decors.add(new Decor("red ganache with dark chocolate", "milk, chocolate", "red", 4));
        decors.add(new Decor("red ganache with white chocolate", "milk, chocolate", "red", 4));
        decors.add(new Decor("red ganache with milk chocolate", "milk, chocolate", "red", 4));
        decors.add(new Decor("blue ganache with dark chocolate", "milk, chocolate", "blue", 4));
        decors.add(new Decor("blue ganache with milk chocolate", "milk, chocolate","blue", 4));
        decors.add(new Decor("blue ganache with white chocolate", "milk, chocolate", "blue", 4));
        decors.add(new Decor("red cream-cheese", "молоко", "red", 4));
        decors.add(new Decor("blue cream-cheese", "молоко", "blue", 4));
        decors.add(new Decor("red velvet", "milk, chocolate", "red", 8));
        decors.add(new Decor("blue velvet", "milk, chocolate","blue", 8));
        decors.add(new Decor("red mirror glaze", "milk, chocolate","red", 7));
        decors.add(new Decor("blue mirror glaze", "milk, chocolate","blue", 7));
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
            if (decor1.getTypeOfDecor() == decor) {
                price = decor1.getPrice();
            }
        }
        return price;
    }
}


