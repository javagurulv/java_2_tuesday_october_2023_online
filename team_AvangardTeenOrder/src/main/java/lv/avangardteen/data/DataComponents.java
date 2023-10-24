package lv.avangardteen.data;

import lv.avangardteen.Category;
import lv.avangardteen.Component;

import java.util.*;

public class DataComponents {

    List<Component> allComponents = List.of(
            new Component(Category.BRAKE, "MH 01", "На уровне колен пользователя, стандарт", 0.0),
            new Component(Category.BRAKE, "MH 02", "На уровне колен пользователя, короткая ручка", 1500.0),
            new Component(Category.BRAKE, "MH 07", "На уровне колен пользователя, длинная ручка", 5700.0),
            new Component(Category.FRONT_WHEEL, "MF 30", "Литые, резиновые, черные, 4 дюйма", 0.0),
            new Component(Category.FRONT_WHEEL, "MF 31", "Литые, резиновые, черные, 5 дюйма", 0.0),
            new Component(Category.FRONT_WHEEL, "MF 34", "Литые, мягкая резина, серые, 5,5 дюйма", 0.0),
            new Component(Category.FRONT_WHEEL, "MF 32", "Литые, резиновые, черные, 6 дюйма", 0.0),
            new Component(Category.FRONT_WHEEL, "MF 35", "Литые, мягкие, алюминиевые, 4 дюйма", 10500.0),
            new Component(Category.FRONT_WHEEL, "MF 36", "Литые, мягкие, алюминиевые, 5 дюйма", 10500.0),
            new Component(Category.FRONT_WHEEL, "MF 37", "Литые, мягкие, алюминиевые, 6 дюйма", 10500.0),
            new Component(Category.ARMREST, "MN 01", "Боковые панели алюминиевые, прямые", 0.0),
            new Component(Category.ARMREST, "MN 02", "Боковые панели пластиковые, загнутые", 3800.0),
            new Component(Category.ARMREST, "MN 05", "Боковые панели c подлокотниками", 11800.0),
            new Component(Category.ARMREST, "MN 06", "Боковые панели с ассимететричными подлокотниками", 22700.0),
            new Component(Category.BACK_WHEEL, "ME 01", "Боковые панели с ассимететричными подлокотниками", 22700.0),
            new Component(Category.BACK_WHEEL, "ME 02", "Боковые панели с ассимететричными подлокотниками", 22700.0),
            new Component(Category.BACK_WHEEL, "ME 03", "Боковые панели с ассимететричными подлокотниками", 22700.0),
            new Component(Category.BACK_WHEEL, "ME 04", "Боковые панели с ассимететричными подлокотниками", 22700.0),
            new Component(Category.BACK_WHEEL, "ME 05", "Боковые панели с ассимететричными подлокотниками", 22700.0),
            new Component(Category.BACK_WHEEL, "ME 06", "Боковые панели с ассимететричными подлокотниками", 22700.0));

    public List<Component> getAllComponents() {
        return allComponents;
    }

    public Component getComponent(String marking) {
        List<Component> components = getAllComponents();
        Component component = null;
        for (Component comp : components) {
            component = comp;
        }
        return component;
    }

    public Set<String> getAllFrontWheelMarking() {
        List<Component> components = getAllComponents();
        Set<String> marking = new HashSet<>();
        for (Component component : components) {
            if (component.getCategory().equals(Category.FRONT_WHEEL)) {
                marking.add(component.getMarking());
            }
        }
        return marking;
    }

    public Set<String> getAllBackWheelMarking() {
        List<Component> components = getAllComponents();
        Set<String> marking = new HashSet<>();
        for (Component component : components) {
            if (component.getCategory().equals(Category.BACK_WHEEL)) {
                marking.add(component.getMarking());
            }
        }
        return marking;
    }

    public Set<String> getAllBrakeMarking() {
        List<Component> components = getAllComponents();
        Set<String> marking = new HashSet<>();
        for (Component component : components) {
            if (component.getCategory().equals(Category.BRAKE)) {
                marking.add(component.getMarking());
            }
        }
        return marking;
    }

    public Set<String> getAllArmrestMarking() {
        List<Component> components = getAllComponents();
        Set<String> marking = new HashSet<>();
        for (Component component : components) {
            if (component.getCategory().equals(Category.ARMREST)) {
                marking.add(component.getMarking());
            }
        }
        return marking;
    }


    public List<Component> allFrontWheels() {
        List<Component> allWheels = new ArrayList<>();
        for (int i = 0; i < getAllComponents().size(); i++) {
            if (getAllComponents().get(i).getCategory().equals(Category.FRONT_WHEEL)) {
                allWheels.add(getAllComponents().get(i));
            }
        }
        return allWheels;
    }

    public List<Component> allArmrest() {
        List<Component> allArmrest = new ArrayList<>();
        for (int i = 0; i < getAllComponents().size(); i++) {
            if (getAllComponents().get(i).getCategory().equals(Category.ARMREST)) {
                allArmrest.add(getAllComponents().get(i));
            }
        }
        return allArmrest;
    }

    public List<Component> allBrakes() {
        List<Component> allBrakes = new ArrayList<>();
        for (int i = 0; i < getAllComponents().size(); i++) {
            if (getAllComponents().get(i).getCategory().equals(Category.BRAKE)) {
                allBrakes.add(getAllComponents().get(i));
            }
        }
        return allBrakes;
    }

    public List<Component> allBackWheels() {
        List<Component> allBackWheel = new ArrayList<>();
        for (int i = 0; i < getAllComponents().size(); i++) {
            if (getAllComponents().get(i).getCategory().equals(Category.BACK_WHEEL)) {
                allBackWheel.add(getAllComponents().get(i));
            }
        }
        return allBackWheel;
    }

    @Override
    public String toString() {
        return "DataComponents{" +
                "allComponents=" + allComponents +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataComponents that = (DataComponents) o;
        return Objects.equals(allComponents, that.allComponents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(allComponents);
    }
}

