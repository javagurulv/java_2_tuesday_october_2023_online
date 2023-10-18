package avangardteen.java;

import java.util.Objects;

public class Component {
    private Category category;
    private String componentID;
    private String information;
    private double price;

    public Component(Category category, String marking, String information, double price) {
        this.category = category;
        this.componentID = marking;
        this.information = information;
        this.price = price;
    }

      public void setCategory(Category category) {
        this.category = category;
    }

    public void setComponentID(String componentID) {
        this.componentID = componentID;
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

    public String getComponentID() {
        return componentID;
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
                "marking='" + componentID + '\'' +
                ", information='" + information + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Component component = (Component) o;
        return Double.compare(component.price, price) == 0 && category == component.category && Objects.equals(componentID, component.componentID) && Objects.equals(information, component.information);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, componentID, information, price);
    }
}
