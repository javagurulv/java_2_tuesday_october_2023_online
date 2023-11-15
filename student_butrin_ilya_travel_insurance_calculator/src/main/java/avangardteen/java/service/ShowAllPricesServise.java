package avangardteen.java.service;

import avangardteen.java.Category;
import avangardteen.java.Client;
import avangardteen.java.Component;
import avangardteen.java.Wheelchair;

import java.security.PublicKey;
import java.util.Map;

public class ShowAllPricesServise {
   Wheelchair wheelchair;

    public ShowAllPricesServise(Wheelchair wheelchair) {
        this.wheelchair = wheelchair;
    }

    public int GetComponentPrice() {
        int priceComponents = 0;
        for (Map.Entry<Category, Component> component : wheelchair.getComponents().entrySet()) {
            priceComponents += component.getValue().getPrice();
        }
        return priceComponents;
    }
    public int getBasePrice(){
        int price = wheelchair.getPriceWheelchair();
        return price;
    }
    public void showComponentPrice() {
        for (Map.Entry<Category, Component> component : wheelchair.getComponents().entrySet()) {
            if (component.getValue().getPrice() > 0)
            System.out.println(component.getKey() + ": " + component.getValue().getInformation() + " цена: " + component.getValue().getPrice());

        }
    }

    public int allPrice () {
        int price = getBasePrice() + GetComponentPrice();
        return price;
        }
        }



