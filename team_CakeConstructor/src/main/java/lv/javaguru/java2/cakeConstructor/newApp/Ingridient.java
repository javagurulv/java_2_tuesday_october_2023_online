package lv.javaguru.java2.cakeConstructor.newApp;


import java.util.Objects;

public class Ingridient {
    private String type;
    private String taste;


    public Ingridient(String type, String taste) {
        this.type = type;
        this.taste = taste;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingridient that = (Ingridient) o;
        return Objects.equals(type, that.type) && Objects.equals(taste, that.taste);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, taste);
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }
}

