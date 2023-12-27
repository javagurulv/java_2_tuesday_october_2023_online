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

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Categories category;

    @Column(name = "marking", nullable = false)
    private String marking;

    @Column(name = "information", nullable = false)
    private String information;

    @Column(name = "price", nullable = false)
    private double price;

    public Components(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCategory(Categories category) {
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

    public Categories getCategory() {
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
        return " индекс =" + id +
                ", марка компонента - '" + marking + '\'' +
                ", характеристика:'" + information + '\'' +
                ", цена=" + price +
                '}' + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Components that = (Components) o;
        return Double.compare(that.price, price) == 0 && Objects.equals(id, that.id) && category == that.category && Objects.equals(marking, that.marking) && Objects.equals(information, that.information);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, marking, information, price);
    }
}
