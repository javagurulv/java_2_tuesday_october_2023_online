package avangardteen.java.service;

import avangardteen.java.Category;
import avangardteen.java.Client;
import avangardteen.java.Component;
import avangardteen.java.Wheelchair;
import avangardteen.java.dependency_injection.DIComponent;
import avangardteen.java.dependency_injection.DIDependency;

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
