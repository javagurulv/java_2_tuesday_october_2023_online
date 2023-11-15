package lv.javaguru.java2.cakeConstructor.privious.cake.domain;

import lv.javaguru.java2.cakeConstructor.privious.new_ingridient_type.Ingridient;

import java.util.List;
import java.util.Objects;

public class NewCake {
    private Long id;
    private String cakeName;
    private String userLogin;
    private List<Ingridient> ingridients;

    public NewCake() {
    }


    public NewCake(String cakeName, String userLogin) {
        this.cakeName = cakeName;
        this.userLogin = userLogin;
    }

    @Override
    public String toString() {
        return "NewCake{" +
                "id=" + id +
                ", cakeName='" + cakeName + '\'' +
                ", userLogin='" + userLogin + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewCake newCake = (NewCake) o;
        return Objects.equals(id, newCake.id) && Objects.equals(cakeName, newCake.cakeName) && Objects.equals(userLogin, newCake.userLogin) && Objects.equals(ingridients, newCake.ingridients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cakeName, userLogin, ingridients);
    }
    public String getCakeName() {
        return cakeName;
    }

    public void setCakeName(String cakeName) {
        this.cakeName = cakeName;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public List<Ingridient> getIngridients() {
        return ingridients;
    }

    public void setIntegers(List<Ingridient> ingridients) {
        this.ingridients=ingridients;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
