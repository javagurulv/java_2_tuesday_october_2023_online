package avangardteen.java.UIAction;

import avangardteen.java.Category;
import avangardteen.java.Component;
import avangardteen.java.Wheelchair;
import avangardteen.java.service.ShowAllPricesServise;

import java.util.Map;

public class ShowAllPricesUIAction implements UIAction{
    ShowAllPricesServise servise;

    public ShowAllPricesUIAction(ShowAllPricesServise servise) {
        this.servise = servise;
    }

    @Override
    public void execute() {
        System.out.println("Общая стоимость кресло-коляски Aвангард Teen: ");
        System.out.println("Базовая цена:  " + servise.getBasePrice());
        System.out.println("Цена платных компонентов: " + servise.GetComponentPrice());
        System.out.println("Общая стоимость: " + servise.allPrice());
    }
}
