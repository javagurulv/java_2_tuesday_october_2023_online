package lv.javaguru.java2.cakeConstructor.core.cake.domain;

import java.util.Objects;

public class Decor {

    private int decorId;
    private String typeOfDecor;
    private String allergens;
    private String colourOfDecor;
    private int price;


    @Override
    public String toString() {
        return "Decor{" +
                "DecorId=" + decorId +
                ", Decor='" + typeOfDecor + '\'' +
                ", Allergens='" + allergens +
                '}';
    }

    public Decor(int decorId, String typeOfDecor, String allergens, String colourOfDecor, int price) {
        this.decorId = decorId;
        this.typeOfDecor = typeOfDecor;
        this.allergens = allergens;
        this.colourOfDecor = colourOfDecor;
        this.price = price;
    }
    public int getDecorId() {
        return decorId;
    }

    public void setDecorId(int decorId) {
        this.decorId = decorId;
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
        return decorId == decor.decorId && price == decor.price && Objects.equals(typeOfDecor, decor.typeOfDecor) && Objects.equals(allergens, decor.allergens) && Objects.equals(colourOfDecor, decor.colourOfDecor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(decorId, typeOfDecor, allergens, colourOfDecor, price);
    }
}
