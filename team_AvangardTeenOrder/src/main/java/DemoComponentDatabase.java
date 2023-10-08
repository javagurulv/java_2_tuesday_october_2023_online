import java.util.*;

public class DemoComponentDatabase {


    public static void main(String[] args) {
        Component component = new Component(Category.BRAKE, "a", "aaaa", 9.00);
        Component component5 = new Component(Category.BRAKE, "y", "yyyy", 912.00);
        Component component1 = new Component(Category.BRAKE, "b", "bbbb", 10.00);
        Component component2 = new Component(Category.ARMREST, "c", "cccc", 9.00);
        Component component3 = new Component(Category.ARMREST, "d", "dddd", 10.00);
        Component component4 = new Component(Category.WHEEL, "o", "oooo", 10.00);

        List<Component> components = new ArrayList<>();
        ComponentDatabase componentDatabase = new ComponentDatabase(components);
        components.add(component);
        components.add(component1);
        components.add(component2);
        components.add(component3);
        components.add(component4);
        components.add(component5);

        //System.out.println(componentDatabase.getComponentList());

        componentDatabase.printAllCategory();
        componentDatabase.printAllMap();

        componentDatabase.printAllComponent();

    }

}
