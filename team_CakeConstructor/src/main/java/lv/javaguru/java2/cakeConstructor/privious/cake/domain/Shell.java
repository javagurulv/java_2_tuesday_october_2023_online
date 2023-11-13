package lv.javaguru.java2.cakeConstructor.privious.cake.domain;

import java.util.Objects;

public class Shell {
    private int shellId;
    private String typeOfShell;
    private String allergens;
    private int weight;
    private int price;


    @Override
    public String toString() {
        return " Shell{" +
                " ShellId=" + shellId +
                ", Shell='" + typeOfShell + '\'' +
                ", Allergens='" + allergens +
                '}';
    }

    public Shell(int shellId, String typeOfShell, String allergens, int weight, int price) {
        this.shellId = shellId;
        this.typeOfShell = typeOfShell;
        this.allergens = allergens;
        this.weight = weight;
        this.price = price;
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
        return shellId == shell.shellId && weight == shell.weight && price == shell.price && Objects.equals(typeOfShell, shell.typeOfShell) && Objects.equals(allergens, shell.allergens);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shellId, typeOfShell, allergens, weight, price);
    }

}
