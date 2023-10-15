package domain;

import java.util.Objects;

public class Filling {
    private String typeOfFilling;
    private String allergens;
    private int weight;
    private int price;
    private int fillingId;


    @Override
    public String toString() {
        return "domain.Filling{" +
                "fillingId=" + fillingId +
                ", typeOfFilling='" + typeOfFilling + '\'' +
                ", allergens='" + allergens + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }

    public Filling(int fillingId, String typeOfFilling, String allergens, int weight, int price) {
        this.fillingId = fillingId;
        this.typeOfFilling = typeOfFilling;
        this.allergens = allergens;
        this.weight = weight;
        this.price = price;

    }
    public int getFillingId() {
        return fillingId;
    }

    public void setFillingId(int fillingId) {
        this.fillingId = fillingId;
    }
    public String getTypeOfFilling() {
        return typeOfFilling;
    }

    public void setTypeOfFilling(String typeOfFilling) {
        this.typeOfFilling = typeOfFilling;
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
        Filling filling = (Filling) o;
        return weight == filling.weight && price == filling.price && fillingId == filling.fillingId && Objects.equals(typeOfFilling, filling.typeOfFilling) && Objects.equals(allergens, filling.allergens);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeOfFilling, allergens, weight, price, fillingId);
    }

}
