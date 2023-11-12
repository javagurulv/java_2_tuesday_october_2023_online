package lv.avangardteen.dto;

import java.util.Objects;

public class Component {
    private Category category;
    private Integer index;
    private String marking;
    private String information;
    private double price;

    public Component(Category category, Integer index, String marking, String information, double price) {
        this.category = category;
        this.index = index;
        this.marking = marking;
        this.information = information;
        this.price = price;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
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
        return  " индекс =" + index +
                ", марка компонента - '" + marking + '\'' +
                ", характеристика:'" + information + '\'' +
                ", цена=" + price +
                '}' + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Component component = (Component) o;
        return index == component.index && Double.compare(component.price, price) == 0 && category == component.category && Objects.equals(marking, component.marking) && Objects.equals(information, component.information);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, index, marking, information, price);
    }
}
