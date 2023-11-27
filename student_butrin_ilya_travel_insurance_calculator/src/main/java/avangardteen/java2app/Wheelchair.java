package avangardteen.java2app;

import avangardteen.java2app.data.DataComponents;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Wheelchair {

    int seatWidth;
    int findSeatDepth;
    int footrestLength;

    private Client userData;
     Map<Category,ComponentWheelchair> components = new HashMap<>();
     private int priceWheelchair = 177700;

    public Client getUserData() {
        return userData;
    }

    public void setUserData(Client userData) {
        this.userData = userData;
    }

    public void addComponents(String userChoose, DataComponents componentList) {
        List<ComponentWheelchair> components1 = componentList.getAllComponents();
        for (ComponentWheelchair component : components1) {
            if (component.getComponentID().equals(userChoose)) {
                components.put(component.getCategory(),component);
            }
        }
    }


    public void setComponents(Map<Category, ComponentWheelchair> components) {
        this.components = components;
    }

    public Map<Category, ComponentWheelchair> getComponents() {
        return components;
    }


    public int getPriceWheelchair() {
        return priceWheelchair;
    }

    public void setPriceWheelchair(int priceWheelchair) {
        this.priceWheelchair = priceWheelchair;
    }
}

