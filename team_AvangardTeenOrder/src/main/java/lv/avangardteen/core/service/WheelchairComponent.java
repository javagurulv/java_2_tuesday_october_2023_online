package lv.avangardteen.core.service;

import lv.avangardteen.data.DataComponents;
import lv.avangardteen.dto.Category;
import lv.avangardteen.dto.Component;
import lv.avangardteen.dto.Wheelchair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class WheelchairComponent extends Wheelchair {
    private DataComponents dataComponents = new DataComponents();
    private Map<Category, Component> components = new HashMap<>();

    public void addComponents(Integer index) {
        List<Component> componentList = dataComponents.getAllComponents();
        for (Component component : componentList) {
            if (component.getIndex() == index) {
                components.put(component.getCategory(), component);
            }
        }
    }

    public Map<Category, Component> getComponents() {
        return this.components;
    }

    private double getPriceComponent() {
        double priceComponents = 0.0;
        for (Map.Entry<Category, Component> component : components.entrySet()) {
            priceComponents += component.getValue().getPrice();
        }
        return priceComponents;
    }

    public double countPriceOrder() {
        return getPriceComponent() + getPriceWheelchair();
    }

    @Override
    public String toString() {
        return "{" +
                components +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WheelchairComponent that = (WheelchairComponent) o;
        return Objects.equals(dataComponents, that.dataComponents) && Objects.equals(components, that.components);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataComponents, components);
    }
}
