/*package avangardteen.java2app.data;

import avangardteen.java2app.Category;
import avangardteen.java2app.ComponentWheelchair;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class DataComponents {

    List<ComponentWheelchair> allComponents = List.of(
            new ComponentWheelchair(Category.BRAKE, "MH 01", "На уровне колен пользователя, стандарт", 0),
            new ComponentWheelchair(Category.BRAKE, "MH 02", "На уровне колен пользователя, короткая ручка", 1500),
            new ComponentWheelchair(Category.BRAKE, "MH 07", "На уровне колен пользователя, длинная ручка", 5700),
            new ComponentWheelchair(Category.FRONT_WHEEL, "MF 30", "Литые, резиновые, черные, 4 дюйма", 0),
            new ComponentWheelchair(Category.FRONT_WHEEL, "MF 31", "Литые, резиновые, черные, 5 дюйма", 0),
            new ComponentWheelchair(Category.FRONT_WHEEL, "MF 04", "Литые, мягкая резина, серые, 5,5 дюйма", 0),
            new ComponentWheelchair(Category.FRONT_WHEEL, "MF 32", "Литые, резиновые, черные, 6 дюйма", 0),
            new ComponentWheelchair(Category.FRONT_WHEEL, "MF 35", "Литые, мягкие, алюминиевые, 4 дюйма", 10500),
            new ComponentWheelchair(Category.FRONT_WHEEL, "MF 36", "Литые, мягкие, алюминиевые, 5 дюйма", 10500),
            new ComponentWheelchair(Category.FRONT_WHEEL, "MF 37", "Литые, мягкие, алюминиевые, 6 дюйма", 10500),
            new ComponentWheelchair(Category.ARMREST, "ME 01", "Боковые панели алюминиевые, прямые", 0),
            new ComponentWheelchair(Category.ARMREST, "ME 02", "Боковые панели пластиковые, загнутые", 3800),
            new ComponentWheelchair(Category.ARMREST, "ME 05", "Боковые панели c подлокотниками", 11800),
            new ComponentWheelchair(Category.ARMREST, "ME 06", "Боковые панели с ассимететричными подлокотниками", 22700),
            new ComponentWheelchair(Category.BACK_WHEEL, "MG 05", "Standart", 0),
            new ComponentWheelchair(Category.BACK_WHEEL, "MG 06", "Hollow rim", 0),
            new ComponentWheelchair(Category.BACK_WHEEL, "MG 11", "Spinergy LX", 83100),
            new ComponentWheelchair(Category.BACK_WHEEL, "MG 15", "Infinity Ultralight", 10500),
            new ComponentWheelchair(Category.BACK_WHEEL, "MG 80", "С Барабанным тормозом для сопровождающего", 29800),
            new ComponentWheelchair(Category.BACK_WHEEL, "MG 83", "Привод под одну руку (с права)", 47700),
            new ComponentWheelchair(Category.BACK_WHEEL, "MG 83", "Привод под одну руку (с лева)", 47700),
            new ComponentWheelchair(Category.BACK_WHEEL_SIZE, "MG 04", "20 дюймов", 0),
            new ComponentWheelchair(Category.BACK_WHEEL_SIZE, "MG 01", "22 дюйма", 0),
            new ComponentWheelchair(Category.BACK_WHEEL_SIZE, "MG 02", "24 дюйма", 0));

    public List<ComponentWheelchair> getAllComponents() {
        return allComponents;
    }


    public List<ComponentWheelchair> allFrontWheels() {
        List<ComponentWheelchair> allWheels = new ArrayList<>();
        for (int i = 0; i < getAllComponents().size(); i++) {
            if (getAllComponents().get(i).getCategory().equals(Category.FRONT_WHEEL)) {
                allWheels.add(getAllComponents().get(i));
            }
        }
        return allWheels;
    }

    public List<ComponentWheelchair> allArmest() {
        List<ComponentWheelchair> allArmest = new ArrayList<>();
        for (int i = 0; i < getAllComponents().size(); i++) {
            if (getAllComponents().get(i).getCategory().equals(Category.ARMREST)) {
                allArmest.add(getAllComponents().get(i));
            }
        }
        return allArmest;
    }

    public List<ComponentWheelchair> allBrakes() {
        List<ComponentWheelchair> allBrakes = new ArrayList<>();
        for (int i = 0; i < getAllComponents().size(); i++) {
            if (getAllComponents().get(i).getCategory().equals(Category.BRAKE)) {
                allBrakes.add(getAllComponents().get(i));
            }
        }
        return allBrakes;
    }
    public List<ComponentWheelchair> allBackWheelsFor20size() {
        List<ComponentWheelchair> allBackWheelFor20size = new ArrayList<>();
        for (int i = 0; i < getAllComponents().size(); i++) {
            if (getAllComponents().get(i).getCategory().equals(Category.BACK_WHEEL) &&
                    getAllComponents().get(i).getComponentID().equals("MG 05")) {
                allBackWheelFor20size.add(getAllComponents().get(i));
            }
        }
        return allBackWheelFor20size;
    }
    public List<ComponentWheelchair> allBackWheelsFor22size() {
        List<ComponentWheelchair> allBackWheelFor22size = new ArrayList<>();
        for (int i = 0; i < getAllComponents().size(); i++) {
            if (getAllComponents().get(i).getComponentID().equals("MG 06") ||
                    getAllComponents().get(i).getComponentID().equals("MG 15") ||
                    getAllComponents().get(i).getComponentID().equals("MG 80")) {
                allBackWheelFor22size.add(getAllComponents().get(i));
            }
        }
        return allBackWheelFor22size;
    }
    public List<ComponentWheelchair> allBackWheelsFor24Size() {
        List<ComponentWheelchair> allBackWheelFor24Size = new ArrayList<>();
        for (int i = 0; i < getAllComponents().size(); i++) {
            if (getAllComponents().get(i).getCategory().equals(Category.BACK_WHEEL)) {
                allBackWheelFor24Size.add(getAllComponents().get(i));
            }
        }
        allBackWheelFor24Size.remove(0);
        return allBackWheelFor24Size;
    }
    public List<ComponentWheelchair> allBackWheels() {
        List<ComponentWheelchair> allBackWheel = new ArrayList<>();
        for (int i = 0; i < getAllComponents().size(); i++) {
            if (getAllComponents().get(i).getCategory().equals(Category.BACK_WHEEL)) {
                allBackWheel.add(getAllComponents().get(i));
            }
        }
        return allBackWheel;
    }
    public List<ComponentWheelchair> allBackWheelsSize() {
        List<ComponentWheelchair> allBackWheelSize = new ArrayList<>();
        for (int i = 0; i < getAllComponents().size(); i++) {
            if (getAllComponents().get(i).getCategory().equals(Category.BACK_WHEEL_SIZE)) {
                allBackWheelSize.add(getAllComponents().get(i));
            }
        }
        return allBackWheelSize;
    }
}
*/
