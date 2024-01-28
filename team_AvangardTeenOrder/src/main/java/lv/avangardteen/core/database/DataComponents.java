package lv.avangardteen.core.database;

import lv.avangardteen.core.domain.Components;

import java.util.List;

public interface DataComponents {

    void addComponent(Components components);
    List<Components> getAllComponents();
    Components getComponent(Integer id);
    List<Components> allFrontWheels();
    List<Components> allFootrest();
    List<Components> allBrakes();
    List<Components> allBackWheels();


}
