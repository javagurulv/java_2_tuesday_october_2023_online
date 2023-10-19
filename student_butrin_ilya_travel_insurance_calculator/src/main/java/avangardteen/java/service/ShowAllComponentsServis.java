package avangardteen.java.service;

import avangardteen.java.Category;
import avangardteen.java.Client;
import avangardteen.java.Component;

import java.util.Map;

public class ShowAllComponentsServis {
    Client client;

    public ShowAllComponentsServis(Client client) {
        this.client = client;
    }
    public Map<Category, Component> getComponent (){
        Map<Category, Component> components = client.getWheelchair().getComponents();
        return components;
    }
}
