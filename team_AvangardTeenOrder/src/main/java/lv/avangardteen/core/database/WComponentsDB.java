package lv.avangardteen.core.database;

import lv.avangardteen.core.domain.WheelchairComponents;

import java.util.List;

public interface WComponentsDB {
    List<WheelchairComponents> getChooseComponents(Long id);
    void addWheelchairComponents(Long idWheelchair, Integer chooseComponent);
    boolean deleteWheelchairComponents(Long id);
    List<WheelchairComponents> getAllWheelchairComponents();
    Double getPriceComponents(Long idWheelchair);
}
