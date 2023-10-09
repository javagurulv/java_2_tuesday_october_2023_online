import java.util.Objects;

public class Decor {
    private String typeOfDecor;
    private String allergens;
    private String colourOfDecor;
    private int price;


    @Override
    public String toString() {
        return "Decor{" +
                "typeOfDecor='" + typeOfDecor + '\'' +
                ", allergens='" + allergens + '\'' +
                ", colourOfDecor='" + colourOfDecor + '\'' +
                ", price=" + price +
                '}';
    }

    public Decor(String typeOfDecor, String allergens, String colourOfDecor, int price) {
        this.typeOfDecor = typeOfDecor;
        this.allergens = allergens;
        this.colourOfDecor = colourOfDecor;
        this.price = price;
    }

    public String getTypeOfDecor() {
        return typeOfDecor;
    }

    public void setTypeOfDecor(String typeOfDecor) {
        this.typeOfDecor = typeOfDecor;
    }

    public String getAllergens() {
        return allergens;
    }

    public void setAllergens(String allergens) {
        this.allergens = allergens;
    }

    public String getColourOfDecor() {
        return colourOfDecor;
    }

    public void setColourOfDecor(String colourOfDecor) {
        this.colourOfDecor = colourOfDecor;
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
        Decor decor = (Decor) o;
        return price == decor.price && Objects.equals(typeOfDecor, decor.typeOfDecor) && Objects.equals(allergens, decor.allergens) && Objects.equals(colourOfDecor, decor.colourOfDecor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeOfDecor, allergens, colourOfDecor, price);
    }

}
