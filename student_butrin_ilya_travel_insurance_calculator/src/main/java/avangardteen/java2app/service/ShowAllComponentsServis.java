package avangardteen.java2app.service;

import avangardteen.java2app.Category;
import avangardteen.java2app.Component;
import avangardteen.java2app.Wheelchair;
import avangardteen.java2app.dependency_injection.DIComponent;
import avangardteen.java2app.dependency_injection.DIDependency;

import java.util.Map;
@DIComponent
public class ShowAllComponentsServis {
 @DIDependency
 Wheelchair wheelchair;


    public Map<Category, Component> getComponent (){
        Map<Category, Component> components = wheelchair.getComponents();
        return components;
    }
}
