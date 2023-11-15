package avangardteen.java.data;

import avangardteen.java.Category;
import avangardteen.java.Component;

import java.util.ArrayList;
import java.util.List;

public class
DataComponents {

    List<Component> allComponents = List.of(
            new Component(Category.BRAKE, "MH 01", "На уровне колен пользователя, стандарт", 0),
            new Component(Category.BRAKE, "MH 02", "На уровне колен пользователя, короткая ручка", 1500),
            new Component(Category.BRAKE, "MH 07", "На уровне колен пользователя, длинная ручка", 5700),
            new Component(Category.FRONT_WHEEL, "MF 30", "Литые, резиновые, черные, 4 дюйма", 0),
            new Component(Category.FRONT_WHEEL, "MF 31", "Литые, резиновые, черные, 5 дюйма", 0),
            new Component(Category.FRONT_WHEEL, "MF 04", "Литые, мягкая резина, серые, 5,5 дюйма", 0),
            new Component(Category.FRONT_WHEEL, "MF 32", "Литые, резиновые, черные, 6 дюйма", 0),
            new Component(Category.FRONT_WHEEL, "MF 35", "Литые, мягкие, алюминиевые, 4 дюйма", 10500),
            new Component(Category.FRONT_WHEEL, "MF 36", "Литые, мягкие, алюминиевые, 5 дюйма", 10500),
            new Component(Category.FRONT_WHEEL, "MF 37", "Литые, мягкие, алюминиевые, 6 дюйма", 10500),
            new Component(Category.ARMREST, "ME 01", "Боковые панели алюминиевые, прямые", 0),
            new Component(Category.ARMREST, "ME 02", "Боковые панели пластиковые, загнутые", 3800),
            new Component(Category.ARMREST, "ME 05", "Боковые панели c подлокотниками", 11800),
            new Component(Category.ARMREST, "ME 06", "Боковые панели с ассимететричными подлокотниками", 22700),
            new Component(Category.BACK_WHEEL, "MG 05", "Standart", 0),
            new Component(Category.BACK_WHEEL, "MG 06", "Hollow rim", 0),
            new Component(Category.BACK_WHEEL, "MG 11", "Spinergy LX", 83100),
            new Component(Category.BACK_WHEEL, "MG 15", "Infinity Ultralight", 10500),
            new Component(Category.BACK_WHEEL, "MG 80", "С Барабанным тормозом для сопровождающего", 29800),
            new Component(Category.BACK_WHEEL, "MG 83", "Привод под одну руку (с права)", 47700),
            new Component(Category.BACK_WHEEL, "MG 83", "Привод под одну руку (с лева)", 47700),
            new Component(Category.BACK_WHEEL_SIZE, "MG 04", "20 дюймов", 0),
            new Component(Category.BACK_WHEEL_SIZE, "MG 01", "22 дюйма", 0),
            new Component(Category.BACK_WHEEL_SIZE, "MG 02", "24 дюйма", 0));

    public List<Component> getAllComponents() {
        return allComponents;
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

    public List<Component> allArmest() {
        List<Component> allArmest = new ArrayList<>();
        for (int i = 0; i < getAllComponents().size(); i++) {
            if (getAllComponents().get(i).getCategory().equals(Category.ARMREST)) {
                allArmest.add(getAllComponents().get(i));
            }
        }
        return allArmest;
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
    public List<Component> allBackWheelsFor20size() {
        List<Component> allBackWheelFor20size = new ArrayList<>();
        for (int i = 0; i < getAllComponents().size(); i++) {
            if (getAllComponents().get(i).getCategory().equals(Category.BACK_WHEEL) &&
                    getAllComponents().get(i).getComponentID().equals("MG 05")) {
                allBackWheelFor20size.add(getAllComponents().get(i));
            }
        }
        return allBackWheelFor20size;
    }
    public List<Component> allBackWheelsFor22size() {
        List<Component> allBackWheelFor22size = new ArrayList<>();
        for (int i = 0; i < getAllComponents().size(); i++) {
            if (getAllComponents().get(i).getComponentID().equals("MG 06") ||
           getAllComponents().get(i).getComponentID().equals("MG 15") ||
           getAllComponents().get(i).getComponentID().equals("MG 80")) {
                allBackWheelFor22size.add(getAllComponents().get(i));
            }
        }
        return allBackWheelFor22size;
    }
    public List<Component> allBackWheelsFor24Size() {
        List<Component> allBackWheelFor24Size = new ArrayList<>();
        for (int i = 0; i < getAllComponents().size(); i++) {
            if (getAllComponents().get(i).getCategory().equals(Category.BACK_WHEEL)) {
                allBackWheelFor24Size.add(getAllComponents().get(i));
                allBackWheelFor24Size.remove(0);
            }
        }
        return allBackWheelFor24Size;
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
    public List<Component> allBackWheelsSize() {
        List<Component> allBackWheelSize = new ArrayList<>();
        for (int i = 0; i < getAllComponents().size(); i++) {
            if (getAllComponents().get(i).getCategory().equals(Category.BACK_WHEEL_SIZE)) {
                allBackWheelSize.add(getAllComponents().get(i));
            }
        }
        return allBackWheelSize;
    }
    }

