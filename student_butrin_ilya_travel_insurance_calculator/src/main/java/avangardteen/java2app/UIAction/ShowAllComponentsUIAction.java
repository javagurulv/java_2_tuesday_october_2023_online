package avangardteen.java2app.UIAction;

import avangardteen.java2app.Category;
import avangardteen.java2app.domen.ComponentWheelchair;
import org.springframework.beans.factory.annotation.Autowired;
import avangardteen.java2app.service.ShowAllComponentsServis;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ShowAllComponentsUIAction implements UIAction {
@Autowired ShowAllComponentsServis servis;

    @Override
    public void execute() {
        Map<Category, ComponentWheelchair> getcomp = servis.getComponent();
        for (Map.Entry<Category, ComponentWheelchair> component : servis.getComponent().entrySet()){

            System.out.println(component.getKey() + ": " + component.getValue().getInformation() + " Цена: " + component.getValue().getPrice());
}
    }
}
