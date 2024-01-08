package avangardteen.java2app.data;

import avangardteen.java2app.Category;
import avangardteen.java2app.ComponentWheelchair;
import avangardteen.java2app.domen.Wheelchair;

import java.util.List;
import java.util.Map;

public interface DatabaseWheelchair {
    void addWheelchairComponent(Map<Category, ComponentWheelchair> components);
    List<Wheelchair> getAllWheelchair ();
}
