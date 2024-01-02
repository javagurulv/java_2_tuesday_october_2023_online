package lv.avangardteen.core.database;

import lv.avangardteen.core.domain.Wheelchair;

import java.util.List;

public interface WheelchairDB {
    List<Wheelchair> getWheelchair();
    void addWheelchair(Wheelchair wheelchair);
    void updateWheelchair(Long id, Wheelchair wheelchair);
    Wheelchair getWheelchair(Long id);
    Long getIdWheelchair();
    Double getPrice(Long id);
}
