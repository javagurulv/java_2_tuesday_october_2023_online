import java.util.ArrayList;
import java.util.List;

public class ComponentList {
    List<Component> breaks = List.of(
            new Component(Category.BRAKE, "MH 01", "На уровне колен пользователя, стандарт", 0),
            new Component(Category.BRAKE, "MH 02", "На уровне колен пользователя, короткая ручка", 1500),
            new Component(Category.BRAKE, "MH 07", "На уровне колен пользователя, длинная ручка", 5700));
    List<Component> wheels = List.of(
            new Component(Category.WHEEL, "MF 30", "Литые, резиновые, черные, 4 дюйма",     0),
            new Component(Category.WHEEL, "MF 31", "Литые, резиновые, черные, 5 дюйма",     0),
            new Component(Category.WHEEL, "MF 04", "Литые, мягкая резина, серые, 5,5 дюйма",0),
            new Component(Category.WHEEL, "MF 30", "Литые, резиновые, черные, 6 дюйма",     0),
            new Component(Category.WHEEL, "MF 35", "Литые, мягкие, алюминиевые, 4 дюйма",   10500),
            new Component(Category.WHEEL, "MF 36", "Литые, мягкие, алюминиевые, 5 дюйма",   10500),
            new Component(Category.WHEEL, "MF 30", "Литые, мягкие, алюминиевые, 6 дюйма",   10500));
    List<Component> armrest  = List.of(
            new Component(Category.ARMREST, "ME 01", "Боковые панели алюминиевые, прямые", 0),
            new Component(Category.ARMREST, "ME 02", "Боковые панели пластиковые, загнутые", 3800 ),
            new Component(Category.ARMREST, "ME 05", "Боковые панели c подлокотниками", 11800 ),
            new Component(Category.ARMREST, "ME 02", "Боковые панели с ассимететричными подлокотниками", 22700 ));

    public List<Component> getBreaks() {
        return breaks;
    }

    public List<Component> getWheels() {
        return wheels;
    }

    public List<Component> getArmrest() {
        return armrest;
    }
}
