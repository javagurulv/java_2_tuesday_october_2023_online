package avangardteen.java2app.data;

import avangardteen.java2app.ComponentWheelchair;

import java.util.List;

public interface DatabaseComponent {
    List<ComponentWheelchair> getAllComponents() ;
    List<ComponentWheelchair> allFrontWheels();
    List<ComponentWheelchair> allArmest();
    List<ComponentWheelchair> allBrakes();
    List<ComponentWheelchair> allBackWheelsFor20size();
    List<ComponentWheelchair> allBackWheelsFor22size();
    List<ComponentWheelchair> allBackWheelsFor24Size();
    List<ComponentWheelchair> allBackWheels();
    List<ComponentWheelchair> allBackWheelsSize();
}
