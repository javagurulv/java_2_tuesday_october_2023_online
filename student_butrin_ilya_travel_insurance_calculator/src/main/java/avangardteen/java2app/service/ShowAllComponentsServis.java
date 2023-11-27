package avangardteen.java2app.service;

import avangardteen.java2app.Category;
import avangardteen.java2app.ComponentWheelchair;
import avangardteen.java2app.Wheelchair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
@Component
public class ShowAllComponentsServis {
 @Autowired
 Wheelchair wheelchair;


    public Map<Category, ComponentWheelchair> getComponent (){
        Map<Category, ComponentWheelchair> components = wheelchair.getComponents();
        return components;
    }
}
