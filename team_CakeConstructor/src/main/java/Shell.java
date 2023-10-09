import java.util.Objects;

public class Shell {
    private String typeOfShell;
    private String allergens;
    private int weight;
    private int price;


    @Override
    public String toString() {
        return "Shell{" +
                "typeOfShell='" + typeOfShell + '\'' +
                ", allergens='" + allergens + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }

    public Shell(String typeOfShell, String allergens, int weight, int price) {
        this.typeOfShell = typeOfShell;
        this.allergens = allergens;
        this.weight = weight;
        this.price = price;
    }

    public String getTypeOfShell() {
        return typeOfShell;
    }

    public void setTypeOfShell(String typeOfShell) {
        this.typeOfShell = typeOfShell;
    }

    public String getAllergens() {
        return allergens;
    }

    public void setAllergens(String allergens) {
        this.allergens = allergens;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shell shell = (Shell) o;
        return weight == shell.weight && price == shell.price && Objects.equals(typeOfShell, shell.typeOfShell) && Objects.equals(allergens, shell.allergens);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeOfShell, allergens, weight, price);
    }
}
