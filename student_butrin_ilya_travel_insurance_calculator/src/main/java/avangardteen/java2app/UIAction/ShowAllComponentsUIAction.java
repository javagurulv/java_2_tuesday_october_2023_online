package avangardteen.java2app.UIAction;

import avangardteen.java2app.Category;
import avangardteen.java2app.Component;
import avangardteen.java2app.dependency_injection.DIComponent;
import avangardteen.java2app.dependency_injection.DIDependency;
import avangardteen.java2app.service.ShowAllComponentsServis;

import java.util.Map;

@DIComponent
public class ShowAllComponentsUIAction implements UIAction {
@DIDependency ShowAllComponentsServis servis;

    @Override
    public void execute() {
        Map<Category, Component> getcomp = servis.getComponent();
        for (Map.Entry<Category, Component> component : servis.getComponent().entrySet()){

            System.out.println(component.getKey() + ": " + component.getValue().getInformation() + " Цена: " + component.getValue().getPrice());
}
    }
}
