package lv.avangardteen.core.database;

/*
import lv.avangardteen.core.domain.Categories;
import lv.avangardteen.core.domain.Components;
import org.springframework.stereotype.Component;

import java.util.*;


public class DataComponentsImpl {

    List<Components> allComponents = List.of(
            new Components(Categories.BRAKE, 31, "MH 01", "На уровне колен пользователя, стандарт", 0.0),
            new Components(Categories.BRAKE, 32, "MH 02", "На уровне колен пользователя, короткая ручка", 1500.0),
            new Components(Categories.BRAKE, 33, "MH 07", "На уровне колен пользователя, длинная ручка", 5700.0),
            new Components(Categories.FRONT_WHEEL, 11, "MF 30", "Литые, резиновые, черные, 4 дюйма", 0.0),
            new Components(Categories.FRONT_WHEEL, 12, "MF 31", "Литые, резиновые, черные, 5 дюйма", 0.0),
            new Components(Categories.FRONT_WHEEL, 13, "MF 04", "Литые, мягкая резина, серые, 5,5 дюйма", 0.0),
            new Components(Categories.FRONT_WHEEL, 14, "MF 32", "Литые, резиновые, черные, 6 дюйма", 0.0),
            new Components(Categories.FRONT_WHEEL, 15, "MF 35", "Литые, мягкие, алюминиевые, 4 дюйма", 10500.0),
            new Components(Categories.FRONT_WHEEL, 16, "MF 36", "Литые, мягкие, алюминиевые, 5 дюйма", 10500.0),
            new Components(Categories.FRONT_WHEEL, 17, "MF 37", "Литые, мягкие, алюминиевые, 6 дюйма", 10500.0),
            new Components(Categories.ARMREST, 41, "MN 01", "Боковые панели алюминиевые, прямые", 0.0),
            new Components(Categories.ARMREST, 42, "MN 02", "Боковые панели пластиковые, загнутые", 3800.0),
            new Components(Categories.ARMREST, 43, "MN 05", "Боковые панели c подлокотниками", 11800.0),
            new Components(Categories.ARMREST, 44, "MN 06", "Боковые панели с ассимететричными подлокотниками", 22700.0),
            new Components(Categories.BACK_WHEEL, 21, "ME 01", "Боковые панели с ассимететричными подлокотниками", 22700.0),
            new Components(Categories.BACK_WHEEL, 22, "ME 02", "Боковые панели с ассимететричными подлокотниками", 22700.0),
            new Components(Categories.BACK_WHEEL, 23, "ME 03", "Боковые панели с ассимететричными подлокотниками", 22700.0),
            new Components(Categories.BACK_WHEEL, 24, "ME 04", "Боковые панели с ассимететричными подлокотниками", 22700.0),
            new Components(Categories.BACK_WHEEL, 25, "ME 05", "Боковые панели с ассимететричными подлокотниками", 22700.0),
            new Components(Categories.BACK_WHEEL, 26, "ME 06", "Боковые панели с ассимететричными подлокотниками", 22700.0));

    public List<Components> getAllComponents() {
        return allComponents;
    }


    public Components getComponent(Integer index) {
        List<Components> components = getAllComponents();
        Components component = null;
        for (Components comp : components) {
            if (comp.getIndex() == index) {
                component = comp;
            }
        }
        return component;
    }

    public List<Integer> getAllIndex() {
        List<Components> components = getAllComponents();
        List<Integer> index = new ArrayList<>();
        for (Components component : components) {
            index.add(component.getIndex());
        }
        return index;
    }

    public List<Components> allFrontWheels() {
        List<Components> allWheels = new ArrayList<>();
        for (int i = 0; i < getAllComponents().size(); i++) {
            if (getAllComponents().get(i).getCategory().equals(Categories.FRONT_WHEEL)) {
                allWheels.add(getAllComponents().get(i));
            }
        }
        return allWheels;
    }

    public List<Components> allArmrest() {
        List<Components> allArmrest = new ArrayList<>();
        for (int i = 0; i < getAllComponents().size(); i++) {
            if (getAllComponents().get(i).getCategory().equals(Categories.ARMREST)) {
                allArmrest.add(getAllComponents().get(i));
            }
        }
        return allArmrest;
    }

    public List<Components> allBrakes() {
        List<Components> allBrakes = new ArrayList<>();
        for (int i = 0; i < getAllComponents().size(); i++) {
            if (getAllComponents().get(i).getCategory().equals(Categories.BRAKE)) {
                allBrakes.add(getAllComponents().get(i));
            }
        }
        return allBrakes;
    }

    public List<Components> allBackWheels() {
        List<Components> allBackWheel = new ArrayList<>();
        for (int i = 0; i < getAllComponents().size(); i++) {
            if (getAllComponents().get(i).getCategory().equals(Categories.BACK_WHEEL)) {
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
        DataComponentsImpl that = (DataComponentsImpl) o;
        return Objects.equals(allComponents, that.allComponents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(allComponents);
    }*/


