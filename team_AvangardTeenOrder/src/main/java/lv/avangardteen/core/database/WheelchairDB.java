package lv.avangardteen.core.database;

import lv.avangardteen.core.domain.Wheelchair;
import lv.avangardteen.core.domain.WheelchairComponents;

import java.util.List;

public interface WheelchairDB {
    List<Wheelchair> getWheelchairsList();
    void addWheelchair(Wheelchair wheelchair);
    Wheelchair getWheelchair(Long id);
    Double getPrice(Long id);
    boolean deleteWheelchairById(Long id);


}
