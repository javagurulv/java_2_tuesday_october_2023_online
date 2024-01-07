package avangardteen.java2app.service;

import avangardteen.java2app.Category;
import avangardteen.java2app.ComponentWheelchair;
import avangardteen.java2app.domen.Wheelchair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
@Component
public class ShowAllPricesServise {
 @Autowired
 Wheelchair wheelchair;

    public int GetComponentPrice() {
        int priceComponents = 0;
        for (Map.Entry<Category, ComponentWheelchair> component : wheelchair.getComponents().entrySet()) {
            priceComponents += component.getValue().getPrice();
        }
        return priceComponents;
    }
    public int getBasePrice(){
        int price = wheelchair.getPriceWheelchair();
        return price;
    }
    public void showComponentPrice() {
        for (Map.Entry<Category, ComponentWheelchair> component : wheelchair.getComponents().entrySet()) {
            if (component.getValue().getPrice() > 0)
            System.out.println(component.getKey() + ": " + component.getValue().getInformation() + " цена: " + component.getValue().getPrice());

        }
    }

    public int allPrice () {
        int price = getBasePrice() + GetComponentPrice();
        return price;
        }
        }



