package avangardTeen.console_ui;

import avangardTeen.domain.Category;
import avangardTeen.domain.Component;
import avangardTeen.domain.Wheelchair;

import java.util.Map;

public class ShowAllPricesUIAction implements UIAction {


    @Override
    public void execute(Wheelchair wheelchair) {
        int priceComponents = 0;
        for (Map.Entry<Category, Component> component : wheelchair.getComponents().entrySet()) {
            priceComponents += component.getValue().getPrice();
        }
        int price = wheelchair.getPriceWheelchair() + priceComponents;
        System.out.println("Общая стоимость: Кресло-коляска Aвангард Teen - " + wheelchair.getPriceWheelchair());
        for (Map.Entry<Category, Component> component : wheelchair.getComponents().entrySet()) {
            System.out.println(component.getKey() + " - " + component.getValue().getPrice());
        }
        System.out.println("Общая стоимость: " + price);
    }
}
