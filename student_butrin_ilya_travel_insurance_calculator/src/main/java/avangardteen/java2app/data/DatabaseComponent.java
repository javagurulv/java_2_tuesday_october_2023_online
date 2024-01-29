package avangardteen.java2app.data;



import avangardteen.java2app.Category;
import avangardteen.java2app.domen.ComponentWheelchair;

import java.util.List;

public interface DatabaseComponent {
    List<ComponentWheelchair> getAllComponents() ;
    List<ComponentWheelchair> allCathegoryComponent(Category category);
    List<ComponentWheelchair> allBackWheelsBySize(String id);
}
