package avangardteen.java2app.domen;

import avangardteen.java2app.Category;
import avangardteen.java2app.ComponentWheelchair;
import avangardteen.java2app.data.DatabaseComponent;
import avangardteen.java2app.domen.Client;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Wheelchair {
int id;
int seatWidth;
int SeatDepth;
int footrestLength;
private Client userData;
Map<Category, ComponentWheelchair> components = new HashMap<>();
private int priceWheelchair = 177700;

public Client getUserData() {
        return userData;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserData(Client userData) {
        this.userData = userData;
    }

    public void addComponents(String userChoose, DatabaseComponent componentList) {
        List<ComponentWheelchair> components1 = componentList.getAllComponents();
        for (ComponentWheelchair component : components1) {
            if (component.getComponentID().equals(userChoose)) {
                components.put(component.getCategory(),component);
            }
        }
    }

    public void setSeatWidth(int seatWidth) {
        this.seatWidth = seatWidth;
    }

    public void setSeatDepth(int seatDepth) {
        SeatDepth = seatDepth;
    }

    public void setFootrestLength(int footrestLength) {
        this.footrestLength = footrestLength;
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

