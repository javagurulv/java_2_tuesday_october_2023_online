package lv.javaguru.java2.createCake.core.cake.domain.ingridients.parts_of_cake.biscuits;

import java.util.Objects;

public class Biscuits {

    private int biscuitNumber;
    private String typeOfBiscuit;
    private String allergens;
    private int price;


    @Override
    public String toString() {
        return "Biscuits{" +
                "biscuit Id = " + biscuitNumber +
                ", type Of biscui t = '" + typeOfBiscuit + '\'' +
                ", allergens = '" + allergens + '\'' +
                '}';
    }


    public Biscuits (int biscuitNumber, String typeOfBiscuit, String allergens, int price){
        this.biscuitNumber=biscuitNumber;
        this.typeOfBiscuit=typeOfBiscuit;
        this.allergens=allergens;
        this.price=price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Biscuits biscuits = (Biscuits) o;
        return biscuitNumber == biscuits.biscuitNumber && price == biscuits.price && Objects.equals(typeOfBiscuit, biscuits.typeOfBiscuit) && Objects.equals(allergens, biscuits.allergens);
    }

    @Override
    public int hashCode() {
        return Objects.hash(biscuitNumber, typeOfBiscuit, allergens, price);
    }



    public int getBiscuitNumber() {
        return biscuitNumber;
    }

    public void setBiscuitNumber(int biscuitNumber) {
        this.biscuitNumber = biscuitNumber;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }



}
