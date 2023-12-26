package lv.avangardteen.core.service;

import lv.avangardteen.core.data.DataComponents;
import lv.avangardteen.core.data.DataComponentsImpl;
import lv.avangardteen.core.domain.Category;
import lv.avangardteen.core.domain.Components;
import lv.avangardteen.core.domain.Wheelchair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class WheelchairComponent extends Wheelchair {
    private DataComponents dataComponents = new DataComponentsImpl();
    private Map<Category, Components> components = new HashMap<>();

    public void addComponents(Integer index) {
        List<Components> componentList = dataComponents.getAllComponents();
        for (Components component : componentList) {
            if (component.getIndex() == index) {
                components.put(component.getCategory(), component);
            }
        }
    }

    public Map<Category, Components> getComponents() {
        return this.components;
    }

    private double getPriceComponent() {
        double priceComponents = 0.0;
        for (Map.Entry<Category, Components> component : components.entrySet()) {
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
