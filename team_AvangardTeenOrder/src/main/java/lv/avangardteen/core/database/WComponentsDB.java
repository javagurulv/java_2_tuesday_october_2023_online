package lv.avangardteen.core.database;

import lv.avangardteen.core.domain.Components;
import lv.avangardteen.core.domain.Wheelchair;
import lv.avangardteen.core.domain.WheelchairComponents;

import java.util.List;

public interface WComponentsDB {
    List<WheelchairComponents> getChooseComponents(Wheelchair wheelchair);
    void addWheelchairComponents(WheelchairComponents wheelchairComponents);
    boolean deleteWheelchairComponents(Long id);
    List<WheelchairComponents> getAllWheelchairComponents();
    Double getPriceComponents(Long idWheelchair);
}
