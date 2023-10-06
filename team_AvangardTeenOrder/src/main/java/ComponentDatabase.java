import java.util.*;

public class ComponentDatabase {

   private List<Component> componentList;

    public ComponentDatabase(List<Component> componentList) {
        this.componentList = new ArrayList<>();
    }

    public void addComponent(Component component) {
        componentList.add(component);
    }

    public List<Component> getComponentList() {
        return componentList;
    }

    private Map<Category,List<Component>> setMapComponent() {
        List<Component> components = this.componentList;
        Map<Category, List<Component>> componentMap = new HashMap<>();
        for(Component component : components) {
            componentMap.put(component.getCategory(), new ArrayList<>());
        }
        for(Component comp : components) {
            componentMap.get(comp.getCategory()).add(comp);
        }
        return componentMap;
    }

    public void printAllMap() {
        for (Map.Entry entry: setMapComponent().entrySet()) {
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






    public static void main(String[] args) {
        Component component = new Component(Category.BRAKE, "a", "aaaa", 9.00);
        Component component5 = new Component(Category.BRAKE, "y", "yyyy", 912.00);
        Component component1 = new Component(Category.BRAKE, "b", "bbbb", 10.00);
        Component component2 = new Component(Category.ARMREST, "c", "cccc", 9.00);
        Component component3 = new Component(Category.ARMREST, "d", "dddd", 10.00);
        Component component4 = new Component(Category.WHEEL, "o", "oooo", 10.00);
        List<Component> components = new ArrayList<>();
        components.add(component);
        components.add(component1);
        components.add(component2);
        components.add(component3);
        components.add(component4);
        components.add(component5);

        Map<Category, List<Component>> componentMap = new HashMap<>();
        for(Component comp : components) {
            componentMap.put(comp.getCategory(), new ArrayList<>());
        }
        for(Component comp : components) {
            componentMap.get(comp.getCategory()).add(comp);
        }
        for (Map.Entry entry: componentMap.entrySet()) {
            System.out.println(entry);
        }
        System.out.println("Привет");


        ArrayList<List<Component>> values = new ArrayList<>(componentMap.values());
        System.out.println("Значения: " + values);

        Set<Category> keys = componentMap.keySet();
        System.out.println("Ключи: " + keys);
    }



}
