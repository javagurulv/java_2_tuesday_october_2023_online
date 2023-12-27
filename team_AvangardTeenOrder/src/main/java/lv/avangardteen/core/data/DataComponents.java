package lv.avangardteen.core.data;

import lv.avangardteen.core.dto.Components;

import java.util.List;

public interface DataComponents {
    List<Components> getAllComponents();
    Components getComponent(Integer index);
    List<Integer> getAllIndex();
    List<Components> allFrontWheels();
    List<Components> allArmrest();
    List<Components> allBrakes();
    List<Components> allBackWheels();

}
