package avangardteen.java.service.valigation;

import avangardteen.java.Category;
import avangardteen.java.CoreError;
import avangardteen.java.Wheelchair;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WheelchairValigator {
    public List<CoreError> errorlist(Wheelchair wheelchair) {
        List<CoreError> errorList = new ArrayList<>();
        BackWheelsWith20Size(wheelchair).ifPresent(errorList::add);
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
}