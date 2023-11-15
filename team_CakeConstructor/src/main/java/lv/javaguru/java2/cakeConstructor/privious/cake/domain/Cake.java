package lv.javaguru.java2.cakeConstructor.privious.cake.domain;

import java.io.Serializable;
import java.util.Objects;

public class Cake  implements Serializable {

    private String biscuit;
    private String filling;
    private String shell;
    private String decor;
    private String clientLogin;
    private int price;


    @Override
    public String toString() {
        return "Cake{" +
                "biscuit='" + biscuit + '\'' +
                ", filling='" + filling + '\'' +
                ", shell='" + shell + '\'' +
                ", decor='" + decor + '\'' +
                ", client=" + clientLogin +
                ", price=" + price +
                '}';
    }

    public Cake (String biscuit, String filling, String shell, String decor, String clientLogin, int price){
        this.biscuit=biscuit;
        this.filling=filling;
        this.shell = shell;
        this.decor = decor;
        this.price=price;
        this.clientLogin = clientLogin;

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

    public String getClientLogin() {
        return clientLogin;
    }

    public void setClientId(String clientLogin) {
        this.clientLogin = clientLogin;
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
        return clientLogin == cake.clientLogin && price == cake.price && Objects.equals(biscuit, cake.biscuit) && Objects.equals(filling, cake.filling) && Objects.equals(shell, cake.shell) && Objects.equals(decor, cake.decor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(biscuit, filling, shell, decor, clientLogin, price);
    }





}