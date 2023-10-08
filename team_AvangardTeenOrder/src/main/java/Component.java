import java.util.Objects;

public class Component {
    private Category category;
    private String marking;
    private String information;
    private double price;

    public Component(Category category, String marking, String information, double price) {
        this.category = category;
        this.marking = marking;
        this.information = information;
        this.price = price;
    }

      public void setCategory(Category category) {
        this.category = category;
    }

    public void setMarking(String marking) {
        this.marking = marking;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public String getMarking() {
        return marking;
    }

    public String getInformation() {
        return information;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Component{" +
                "marking='" + marking + '\'' +
                ", information='" + information + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Component component = (Component) o;
        return Double.compare(component.price, price) == 0 && category == component.category && Objects.equals(marking, component.marking) && Objects.equals(information, component.information);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, marking, information, price);
    }
}
