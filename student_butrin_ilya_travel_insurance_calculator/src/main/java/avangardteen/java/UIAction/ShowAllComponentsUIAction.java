package avangardteen.java.UIAction;

import avangardteen.java.Category;
import avangardteen.java.Component;
import avangardteen.java.Wheelchair;
import avangardteen.java.dependency_injection.DIComponent;
import avangardteen.java.dependency_injection.DIDependency;
import avangardteen.java.service.ShowAllComponentsServis;

import java.util.List;
import java.util.Map;
import java.util.Objects;
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
