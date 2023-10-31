package lv.javaguru.java2.createCake.core.cake.domain.ingridients.parts_of_cake.shells;

import java.util.Objects;

public class Shells {
    private int shellId;
    private String typeOfShell;
    private String allergens;
    private int price;


    @Override
    public String toString() {
        return "Shells{" +
                "shell Id = " + shellId +
                ", type of Shell = '" + typeOfShell + '\'' +
                ", allergens = '" + allergens + '\'' +
                '}';
    }

    public Shells (int shellId, String typeOfShell, String allergens, int price){
        this.shellId=shellId;
        this.typeOfShell=typeOfShell;
        this.allergens=allergens;
        this.price=price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shells shells = (Shells) o;
        return shellId == shells.shellId && price == shells.price && Objects.equals(typeOfShell, shells.typeOfShell) && Objects.equals(allergens, shells.allergens);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shellId, typeOfShell, allergens, price);
    }

    public int getShellId() {
        return shellId;
    }

    public void setShellId(int shellId) {
        this.shellId = shellId;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}
