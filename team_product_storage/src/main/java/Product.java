import java.util.Objects;

public class Product {
    private String name;
    private String IDnumber;

    public Product(String name, String IDnumber) {
        this.name = name;
        this.IDnumber = IDnumber;
    }

    public String getName() {
        return name;
    }
    public String getIDnumber() {
        return IDnumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIDnumber(String IDnumber) {
        this.IDnumber = IDnumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return Objects.equals(getName(), product.getName()) && Objects.equals(getIDnumber(), product.getIDnumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getIDnumber());
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", IDnumber='" + IDnumber + '\'' +
                '}';
    }
}
