package lv.javaguru.java2.createCake.core.cake.domain.ingridients.parts_of_cake.fillings;

import java.util.Objects;

public class Fillings {

    private int fillingId;
    private String fillingType;
    private String allergens;
    private int price;

    @Override
    public String toString() {
        return "Fillings{" +
                "filling Id = " + fillingId +
                ", filling Type = '" + fillingType + '\'' +
                ", allergens = '" + allergens + '\'' +
                '}';
    }

    public Fillings (int fillingId, String fillingType, String allergens, int price){
        this.fillingId=fillingId;
        this.fillingType=fillingType;
        this.allergens=allergens;
        this.price=price;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fillings fillings = (Fillings) o;
        return fillingId == fillings.fillingId && price == fillings.price && Objects.equals(fillingType, fillings.fillingType) && Objects.equals(allergens, fillings.allergens);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fillingId, fillingType, allergens, price);
    }


    public void setFillingId(int fillingId) {
        this.fillingId = fillingId;
    }
    public int getFillingId() {
        return fillingId;
    }

    public String getFillingType() {
        return fillingType;
    }

    public void setFillingType(String fillingType) {
        this.fillingType = fillingType;
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
