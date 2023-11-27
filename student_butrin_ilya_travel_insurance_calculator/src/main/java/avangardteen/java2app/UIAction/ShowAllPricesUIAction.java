package avangardteen.java2app.UIAction;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import avangardteen.java2app.service.ShowAllPricesServise;

@Component
public class ShowAllPricesUIAction implements UIAction{
  @Autowired
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
