package lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects;

import java.util.Date;
import java.util.Objects;

public class Cake {

    private String biscuit;
    private String filling;
    private String shell;
    private String decor;
    private int status;
    private Date dateOfPreparing;
    private int price;
    private String userLogin;


    @Override
    public String toString() {
        return "Cake{" +
                "biscuit='" + biscuit + '\'' +
                ", filling='" + filling + '\'' +
                ", shell='" + shell + '\'' +
                ", decor='" + decor + '\'' +
                ", status='" + status + '\'' +
                ", dateOfPreparing=" + dateOfPreparing +
                ", price=" + price +
                '}';
    }



    public Cake(String userLogin , String biscuit, String filling, String shell, String decor, int status, Date dateOfPreparing, int price){
        this.userLogin = userLogin;
        this.biscuit=biscuit;
        this.filling=filling;
        this.shell=shell;
        this.decor=decor;
        this.status=status;
        this.dateOfPreparing=dateOfPreparing;
        this.price=price;

    }



    public Cake( String biscuit, String filling, String shell, String decor, int price){
        this.biscuit=biscuit;
        this.filling=filling;
        this.shell=shell;
        this.decor=decor;
        this.price=price;

    }
    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cake cake = (Cake) o;
        return status == cake.status && price == cake.price && Objects.equals(biscuit, cake.biscuit) && Objects.equals(filling, cake.filling) && Objects.equals(shell, cake.shell) && Objects.equals(decor, cake.decor) && Objects.equals(dateOfPreparing, cake.dateOfPreparing) && Objects.equals(userLogin, cake.userLogin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(biscuit, filling, shell, decor, status, dateOfPreparing, price, userLogin);
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getDateOfPreparing() {
        return dateOfPreparing;
    }

    public void setDateOfPreparing(Date dateOfPreparing) {
        this.dateOfPreparing = dateOfPreparing;
    }
}
