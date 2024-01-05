package lv.avangardteen.core.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "components")
public class Components {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "marking", nullable = false)
    private String marking;

    @Column(name = "information", nullable = false)
    private String information;

    @Column(name = "price", nullable = false)
    private double price;

    public Components() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMarking() {
        return marking;
    }

    public void setMarking(String marking) {
        this.marking = marking;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Components that = (Components) o;
        return Double.compare(that.price, price) == 0 && Objects.equals(id, that.id) && Objects.equals(category, that.category) && Objects.equals(marking, that.marking) && Objects.equals(information, that.information);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, marking, information, price);
    }

    @Override
    public String toString() {
        return " индекс = " + id +
                ", характеристика: " + information +
                ", цена = " + price +
                ';' + '\n';
    }


}
