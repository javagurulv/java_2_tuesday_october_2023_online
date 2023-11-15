package avangardteen.java.service;

import avangardteen.java.Category;
import avangardteen.java.Client;
import avangardteen.java.Component;
import avangardteen.java.Wheelchair;

import java.util.Map;

public class ShowAllComponentsServis {
    Wheelchair wheelchair;

    public ShowAllComponentsServis(Wheelchair wheelchair) {
        this.wheelchair = wheelchair;
    }

    public Map<Category, Component> getComponent (){
        Map<Category, Component> components = wheelchair.getComponents();
        return components;
    }
}
