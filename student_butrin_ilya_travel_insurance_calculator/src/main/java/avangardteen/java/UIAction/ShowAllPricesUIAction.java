package avangardteen.java.UIAction;

import avangardteen.java.Category;
import avangardteen.java.Component;
import avangardteen.java.Wheelchair;
import avangardteen.java.dependency_injection.DIComponent;
import avangardteen.java.dependency_injection.DIDependency;
import avangardteen.java.service.ShowAllPricesServise;

import java.util.Map;
@DIComponent
public class ShowAllPricesUIAction implements UIAction{
  @DIDependency
  ShowAllPricesServise servise;

    @Override
    public void execute() {
        System.out.println("Общая стоимость кресло-коляски Aвангард Teen: ");
        System.out.println("Базовая цена:  " + servise.getBasePrice());
        System.out.println("Цена платных компонентов: " + servise.GetComponentPrice());
        servise.showComponentPrice();
        System.out.println("Общая стоимость: " + servise.allPrice());
    }
}
