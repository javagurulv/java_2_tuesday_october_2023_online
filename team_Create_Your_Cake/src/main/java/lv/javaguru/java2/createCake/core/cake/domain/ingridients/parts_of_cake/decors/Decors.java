package lv.javaguru.java2.createCake.core.cake.domain.ingridients.parts_of_cake.decors;

import java.util.Objects;

public class Decors {

    private int decorId;
    private String typeOfDecor;
    private String decorColour;
    private int price;


    @Override
    public String toString() {
        return "Decors{" +
                "Decor Id = " + decorId +
                ", Type Of Decor='" + typeOfDecor + '\'' +
                ", Colour = '" + decorColour + '\'' +
                '}';
    }

    public Decors(int decorId, String typeOfDeco, String decorColour, int price){
        this.decorId=decorId;
        this.typeOfDecor=typeOfDeco;
        this.decorColour=decorColour;
        this.price=price;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Decors decors = (Decors) o;
        return decorId == decors.decorId && price == decors.price && Objects.equals(typeOfDecor, decors.typeOfDecor) && Objects.equals(decorColour, decors.decorColour);
    }

    @Override
    public int hashCode() {
        return Objects.hash(decorId, typeOfDecor, decorColour, price);
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

    public String getDecorColour() {
        return decorColour;
    }

    public void setDecorColour(String decorColour) {
        this.decorColour = decorColour;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}
