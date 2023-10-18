package avangardteen.java;

import avangardteen.java.data.DataComponents;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Wheelchair {

    int seatWidth;
    int findSeatDepth;
    int footrestLength;



    private Client userData;
     Map<Category,Component> components = new HashMap<>();
     private int priceWheelchair = 177700;



    public Client getUserData() {
        return userData;
    }

    public void setUserData(Client userData) {
        this.userData = userData;
    }

    public void addComponents(String userChoose, DataComponents componentList) {
        List<Component> components1 = componentList.getAllComponents();
        for (Component component : components1) {
            if (component.getComponentID().equals(userChoose)) {
                components.put(component.getCategory(),component);
            }
        }
    }


    public void setComponents(Map<Category, Component> components) {
        this.components = components;
    }

    public Map<Category, Component> getComponents() {
        return components;
    }


    public int getPriceWheelchair() {
        return priceWheelchair;
    }

    public void setPriceWheelchair(int priceWheelchair) {
        this.priceWheelchair = priceWheelchair;
    }
}

