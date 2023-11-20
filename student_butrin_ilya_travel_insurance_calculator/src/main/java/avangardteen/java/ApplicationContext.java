package avangardteen.java;

import avangardteen.java.UIAction.*;
import avangardteen.java.data.DataComponents;
import avangardteen.java.data.DataUsers;
import avangardteen.java.service.*;
import avangardteen.java.service.valigation.AddAntropologDateValigation;
import avangardteen.java.service.valigation.ChangeAntropologDateValigation;
import avangardteen.java.service.valigation.WheelchairValigator;

import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {
    private Map<Class, Object> beans = new HashMap<>();

    public ApplicationContext() {
        beans.put(UserSizes.class, new UserSizes());
        beans.put(Wheelchair.class, new Wheelchair());
        beans.put(AddAntropologDateValigation.class, new AddAntropologDateValigation());
        beans.put(DataUsers.class, new DataUsers());
        beans.put(WheelchairValigator.class, new WheelchairValigator());
        beans.put(DataComponents.class, new DataComponents());
        beans.put(AddUserDataServis.class, new AddUserDataServis(
                getBean(DataUsers.class),
                getBean(UserSizes.class),
                getBean(Wheelchair.class),
                getBean(WheelchairValigator.class)));
        beans.put(ChooseWheelChairComponentsServis.class, new ChooseWheelChairComponentsServis(
                getBean(DataComponents.class),
                getBean(Wheelchair.class)));
        beans.put(AddAtropologDateServis.class, new AddAtropologDateServis(
                getBean(UserSizes.class),
                getBean(AddAntropologDateValigation.class)));
        beans.put(GetAntropometricDataServis.class, new GetAntropometricDataServis(
                getBean(UserSizes.class)));
        beans.put(ChangeComponentServise.class, new ChangeComponentServise(
                getBean(DataComponents.class),
                getBean(Wheelchair.class),
                getBean(WheelchairValigator.class)));
        beans.put(ChangeComponentUIAction.class, new ChangeComponentUIAction(
                getBean(ChangeComponentServise.class)));
        beans.put( ShowAllComponentsServis.class, new ShowAllComponentsServis(
                getBean(Wheelchair.class)));
        beans.put( ShowAllComponentsUIAction.class, new ShowAllComponentsUIAction(
                getBean(ShowAllComponentsServis.class)));
        beans.put( ShowAllPricesServise.class, new ShowAllPricesServise(
                getBean(Wheelchair.class)));
        beans.put( ShowAllPricesUIAction.class, new ShowAllPricesUIAction(
                getBean(ShowAllPricesServise.class)));
        beans.put( ChooseWheelchairComponensUIAction.class, new ChooseWheelchairComponensUIAction(
                getBean(ChooseWheelChairComponentsServis.class)));
        beans.put( AddPersonalDateIUAction.class, new AddPersonalDateIUAction(
                getBean(AddUserDataServis.class)));
        beans.put( ShowDataSizeUIActive.class, new ShowDataSizeUIActive(
                getBean(GetAntropometricDataServis.class)));
        beans.put( AddAnthropometricDataIUActiv.class, new AddAnthropometricDataIUActiv(
                getBean(AddAtropologDateServis.class)));
        beans.put( ChangeAntropologDateValigation.class, new ChangeAntropologDateValigation());
        beans.put( ChangeAntropometricDataService.class, new ChangeAntropometricDataService(
                getBean(UserSizes.class),getBean(ChangeAntropologDateValigation.class)));
        beans.put( ChangenAtropologDateUIAAction.class, new ChangenAtropologDateUIAAction(
                getBean(ChangeAntropometricDataService.class)));
    }

    public <T extends Object> T getBean(Class c) {
        return (T) beans.get(c);
    }
}
