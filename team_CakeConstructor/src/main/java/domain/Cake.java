package domain;

import java.util.Objects;

public class Cake {

    private String biscuit;
    private String filling;
    private String shell;
    private String decor;
    private int clientId;
    private int price;


    @Override
    public String toString() {
        return "domain.Cake{" +
                "biscuit='" + biscuit + '\'' +
                ", filling='" + filling + '\'' +
                ", shell='" + shell + '\'' +
                ", decor='" + decor + '\'' +
                ", clientId=" + clientId +
                ", price=" + price +
                '}';
    }

    public Cake (String biscuit, String filling, String shell, String decor, int clientId, int price){
        this.biscuit=biscuit;
        this.filling=filling;
        this.shell = shell;
        this.decor = decor;
        this.price=price;
        this.clientId = clientId;

    }

    public String getBiscuit() {
        return biscuit;
    }

    public void setBiscuit(String biscuit) {
        this.biscuit = biscuit;
    }

    public String getFilling() {
        return filling;
    }

    public void setFilling(String filling) {
        this.filling = filling;
    }

    public String getShell() {
        return shell;
    }

    public void setShell(String shell) {
        this.shell = shell;
    }

    public String getDecor() {
        return decor;
    }

    public void setDecor(String decor) {
        this.decor = decor;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
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
        Cake cake = (Cake) o;
        return clientId == cake.clientId && price == cake.price && Objects.equals(biscuit, cake.biscuit) && Objects.equals(filling, cake.filling) && Objects.equals(shell, cake.shell) && Objects.equals(decor, cake.decor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(biscuit, filling, shell, decor, clientId, price);
    }





}