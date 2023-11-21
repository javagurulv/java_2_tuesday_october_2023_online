package avangardteen.java2app.service;

import avangardteen.java2app.Category;
import avangardteen.java2app.Component;
import avangardteen.java2app.Wheelchair;
import avangardteen.java2app.dependency_injection.DIComponent;
import avangardteen.java2app.dependency_injection.DIDependency;

import java.util.Map;
@DIComponent
public class ShowAllPricesServise {
 @DIDependency
 Wheelchair wheelchair;

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



