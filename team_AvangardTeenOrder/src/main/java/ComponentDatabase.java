import java.util.*;

public class ComponentDatabase {

    private List<Component> componentList;

    public ComponentDatabase(List<Component> componentList) {
        this.componentList = componentList;
    }

    public void addComponent(Component component) {

        this.componentList.add(component);
    }

    public List<Component> getComponentList() {
        return this.componentList;
    }

    private Map<Category, List<Component>> setMapComponent() {
        List<Component> components = this.componentList;
        Map<Category, List<Component>> componentMap = new HashMap<>();
        for (Component component : components) {
            componentMap.put(component.getCategory(), new ArrayList<>());
        }
        for (Component comp : components) {
            componentMap.get(comp.getCategory()).add(comp);
        }
        return componentMap;
    }

    public void printAllMap() {
        for (Map.Entry entry : setMapComponent().entrySet()) {
            if (!setMapComponent().isEmpty()) {
                System.out.println(entry);
            }
        }
    }

    public void printAllComponent() {
        ArrayList<List<Component>> values = new ArrayList<>(setMapComponent().values());
        if (!setMapComponent().isEmpty()) {
            System.out.println("Значения: " + values);
        }
    }

    public void printAllCategory() {
        Set<Category> keys = setMapComponent().keySet();
        if (!setMapComponent().isEmpty()) {
            System.out.println("Ключи: " + keys);
        }
    }

    @Override
    public String toString() {
        return "ComponentDatabase{" +
                "componentList=" + componentList +
                '}';
    }

}
