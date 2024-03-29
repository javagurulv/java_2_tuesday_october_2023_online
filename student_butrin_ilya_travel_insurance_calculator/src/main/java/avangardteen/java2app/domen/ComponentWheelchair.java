package avangardteen.java2app.domen;

import avangardteen.java2app.Category;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Objects;
@Component
@Entity
@Table (name  = "components")
public class ComponentWheelchair {
    @Column  (name = "Category")
    private Category category;
    @Id
    @Column (name = "id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private String componentID;
    @Column (name = "information")
    private String information;
    @Column (name = "price")
    private double price;

    public ComponentWheelchair(Category category, String componentID, String information, double price) {
        this.category = category;
        this.componentID = componentID;
        this.information = information;
        this.price = price;
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

    public ComponentWheelchair() {
    }

    public void setCategory(Category category) {
        this.category = category;
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
        return "ComponentWheelchair{" +
                "category=" + category +
                ", componentID='" + componentID + '\'' +
                ", information='" + information + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComponentWheelchair component = (ComponentWheelchair) o;
        return Double.compare(component.price, price) == 0 && category == component.category && Objects.equals(componentID, component.componentID) && Objects.equals(information, component.information);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, componentID, information, price);
    }
}
