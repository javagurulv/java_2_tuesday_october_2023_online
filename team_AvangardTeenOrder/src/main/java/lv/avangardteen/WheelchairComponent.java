package lv.avangardteen;

import lv.avangardteen.data.DataComponents;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class WheelchairComponent {
    private DataComponents dataComponents = new DataComponents();
    private Map<Category, Component> components = new HashMap<>();


    public WheelchairComponent() {


    }


    public void addComponents(String userChoose) {
        List<Component> componentList = dataComponents.getAllComponents();
        for (Component component : componentList) {
            if (component.getMarking().equals(userChoose)) {
                components.put(component.getCategory(), component);
            }
        }
    }



    public Map<Category, Component> getComponents() {
        return this.components;
    }


    public int getPriceComponent() {
        int priceComponents = 0;
        for (Map.Entry<Category, Component> component : components.entrySet()) {
            priceComponents += component.getValue().getPrice();
        }
        return priceComponents;
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
