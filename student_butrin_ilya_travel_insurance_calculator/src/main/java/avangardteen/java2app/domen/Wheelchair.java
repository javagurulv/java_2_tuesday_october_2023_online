package avangardteen.java2app.domen;

import avangardteen.java2app.Category;
import avangardteen.java2app.domen.ComponentWheelchair;
import avangardteen.java2app.data.DatabaseComponent;
import avangardteen.java2app.domen.Client;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Entity
@Table (name = "wheelChair")
public class Wheelchair {
@Id
@Column (name = "id")
@GeneratedValue (strategy = GenerationType.IDENTITY)
int id;
@Column (name = "seatWidth")
int seatWidth;
@Column (name = "SeatDepth")
int SeatDepth;
@Column (name = "footrestLength")
int footrestLength;

//private Client userData;
Map<Category, ComponentWheelchair> components = new HashMap<>();
@Column (name = "BREAK")
 String breaks;
@Column (name = "ARMREST")
 String armrest;
@Column (name = "BACK_WHEEL")
 String back_wheels;
@Column (name  = "BACK_WHEEL_SIZE")
 String back_wheels_size;
@Column (name = "FRONT_WHEEL")
String front_wheel;
 @Column (name = "price")
private int priceWheelchair = 177700;

    public String getBack_wheels_sizeon() {
        return back_wheels_size;
    }

    public void setBack_wheels_sizeon(String back_wheels_sizeon) {
        this.back_wheels_size = back_wheels_sizeon;
    }

    public Wheelchair() {
    }

    public int getSeatWidth() {
        return seatWidth;
    }

    public int getSeatDepth() {
        return SeatDepth;
    }

    public int getFootrestLength() {
        return footrestLength;
    }

    public String getBreaks() {
        return breaks;
    }

    public void setBreaks(String breaks) {
        this.breaks = breaks;
    }

    public String getArmrest() {
        return armrest;
    }

    public void setArmrest(String armrest) {
        this.armrest = armrest;
    }

    public String getBack_wheels() {
        return back_wheels;
    }

    public void setBack_wheels(String back_wheels) {
        this.back_wheels = back_wheels;
    }

    public String getBack_wheels_size() {
        return back_wheels_size;
    }

    public void setBack_wheels_size(String back_wheels_size) {
        this.back_wheels_size = back_wheels_size;
    }

    public String getFront_wheel() {
        return front_wheel;
    }

    public void setFront_wheel(String front_wheel) {
        this.front_wheel = front_wheel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
//
//    public void setUserData(Client userData) {
//        this.userData = userData;
//    }

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

