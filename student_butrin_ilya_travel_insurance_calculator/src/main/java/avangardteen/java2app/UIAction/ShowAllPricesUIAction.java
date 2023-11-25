package avangardteen.java2app.UIAction;

import avangardteen.java2app.dependency_injection.DIComponent;
import avangardteen.java2app.dependency_injection.DIDependency;
import avangardteen.java2app.service.ShowAllPricesServise;

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
