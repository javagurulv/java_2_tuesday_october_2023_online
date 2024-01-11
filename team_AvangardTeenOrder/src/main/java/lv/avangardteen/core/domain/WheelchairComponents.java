package lv.avangardteen.core.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "order_components")
public class WheelchairComponents {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional=false, cascade=CascadeType.ALL)
    @JoinColumn(name = "wheelchair_id", nullable = false)
    private Wheelchair wheelchair;

    @ManyToOne
    @JoinColumn(name = "component_id")
    private Components components;

    @Column(name = "price_component")
    private Double priceComponent;

    public WheelchairComponents() {
    }

    public WheelchairComponents(Long id, Wheelchair wheelchair, Components components) {
        this.id = id;
        this.wheelchair = wheelchair;
        this.components = components;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Wheelchair getWheelchair() {
        return wheelchair;
    }

    public void setWheelchair(Wheelchair wheelchair) {
        this.wheelchair = wheelchair;
    }

    public Components getComponents() {
        return components;
    }

    public void setComponents(Components components) {
        this.components = components;
    }

    public Double getPriceComponent() {
        return priceComponent;
    }

    public void setPriceComponent(Double priceComponent) {
        this.priceComponent = priceComponent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WheelchairComponents that = (WheelchairComponents) o;
        return Objects.equals(id, that.id) && Objects.equals(wheelchair, that.wheelchair) && Objects.equals(components, that.components);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, wheelchair, components);
    }

    @Override
    public String toString() {
        return "WheelchairComponents{" +
                "components =" + components +
                '}';
    }
}
