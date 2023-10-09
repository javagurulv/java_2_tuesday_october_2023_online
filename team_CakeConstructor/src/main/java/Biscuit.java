import java.util.Objects;

public class Biscuit {

    private String typeOfBiscuit;
    private String allergens;
    private int weight;
    private int price;


    @Override
    public String toString() {
        return "Biscuit{" +
                "typeOfBiscuit='" + typeOfBiscuit + '\'' +
                ", allergens='" + allergens + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }

    public Biscuit(String typeOfBiscuit, String allergens, int weight, int price) {
        this.typeOfBiscuit = typeOfBiscuit;
        this.allergens = allergens;
        this.weight = weight;
        this.price = price;

    }

    public String getTypeOfBiscuit() {
        return typeOfBiscuit;
    }

    public void setTypeOfBiscuit(String typeOfBiscuit) {
        this.typeOfBiscuit = typeOfBiscuit;
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
        Biscuit biscuit = (Biscuit) o;
        return weight == biscuit.weight && price == biscuit.price && Objects.equals(typeOfBiscuit, biscuit.typeOfBiscuit) && Objects.equals(allergens, biscuit.allergens);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeOfBiscuit, allergens, weight, price);
    }

}
