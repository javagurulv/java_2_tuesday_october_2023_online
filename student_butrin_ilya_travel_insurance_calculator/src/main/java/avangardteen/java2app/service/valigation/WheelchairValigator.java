package avangardteen.java2app.service.valigation;

import avangardteen.java2app.Category;
import avangardteen.java2app.CoreError;
import avangardteen.java2app.domen.Wheelchair;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Component
public class WheelchairValigator {
    public List<CoreError> errorlist(Wheelchair wheelchair) {
        List<CoreError> errorList = new ArrayList<>();
        BackWheelsWith20Size(wheelchair).ifPresent(errorList::add);
        BackWheelsWith22Size(wheelchair).ifPresent(errorList::add);
        BackWheelsWith24Size(wheelchair).ifPresent(errorList::add);
        return errorList;
    }


    public Optional<CoreError> BackWheelsWith20Size(Wheelchair wheelchair) {
        Optional<CoreError> err;
        if (wheelchair.getComponents().get(Category.BACK_WHEEL_SIZE).getComponentID().equals("MG 04")
                && (wheelchair.getComponents().get(Category.BACK_WHEEL).getComponentID().equals("MG 06")
                || wheelchair.getComponents().get(Category.BACK_WHEEL).getComponentID().equals("MG 11")
                || wheelchair.getComponents().get(Category.BACK_WHEEL).getComponentID().equals("MG 80"))) {
            err = Optional.of(new CoreError("Заднии колеса", "Данный тип колеса не может быть размером 20 дюймов."));
        } else err = Optional.empty();
        return err;
    }
    public Optional<CoreError> BackWheelsWith22Size(Wheelchair wheelchair) {
        Optional<CoreError> err;
        if (wheelchair.getComponents().get(Category.BACK_WHEEL_SIZE).getComponentID().equals("MG 01")
                && (wheelchair.getComponents().get(Category.BACK_WHEEL).getComponentID().equals("MG 05")
                || wheelchair.getComponents().get(Category.BACK_WHEEL).getComponentID().equals("MG 11")
                || wheelchair.getComponents().get(Category.BACK_WHEEL).getComponentID().equals("MG 80")
                || wheelchair.getComponents().get(Category.BACK_WHEEL).getComponentID().equals("MG 83"))) {
            err = Optional.of(new CoreError("Заднии колеса", "Данный тип колеса не может быть размером 22 дюймов."));
        } else err = Optional.empty();
        return err;
    }
    public Optional<CoreError> BackWheelsWith24Size(Wheelchair wheelchair) {
        Optional<CoreError> err;
        if (wheelchair.getComponents().get(Category.BACK_WHEEL_SIZE).getComponentID().equals("MG 02")
                && (wheelchair.getComponents().get(Category.BACK_WHEEL).getComponentID().equals("MG 05")
                || wheelchair.getComponents().get(Category.BACK_WHEEL).getComponentID().equals("MG 11"))) {
            err = Optional.of(new CoreError("Заднии колеса", "Данный тип колеса не может быть размером 24 дюймов."));
        } else err = Optional.empty();
        return err;
    }
}