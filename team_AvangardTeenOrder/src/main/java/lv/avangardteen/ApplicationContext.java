package lv.avangardteen;

import lv.avangardteen.UIAction.*;
import lv.avangardteen.core.service.*;
import lv.avangardteen.core.service.validate.*;
import lv.avangardteen.data.DataComponents;
import lv.avangardteen.data.DataOrders;
import lv.avangardteen.data.Database;

import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {

    private Map<Class, Object> beans = new HashMap<>();


    public ApplicationContext() {
        beans.put(Database.class, new DataOrders());
        beans.put(DataComponents.class, new DataComponents());

        beans.put(ClientIdValidator.class, new ClientIdValidator(getBean(Database.class)));
        beans.put(PersonalDateValidation.class, new PersonalDateValidation());
        beans.put(PersonalSizeValidator.class, new PersonalSizeValidator());
        beans.put(ComponentValidator.class, new ComponentValidator());

        beans.put(ClientOrderValidator.class, new ClientOrderValidator(
                getBean(PersonalDateValidation.class),
                getBean(PersonalSizeValidator.class),
                getBean(ComponentValidator.class)));
        beans.put(ChangePersonalDateValidator.class, new ChangePersonalDateValidator(
                getBean(ClientIdValidator.class),
                getBean(PersonalDateValidation.class)));
        beans.put(ChangePersonalSizeValidator.class, new ChangePersonalSizeValidator(
                getBean(ClientIdValidator.class),
                getBean(PersonalSizeValidator.class)));
        beans.put(ChooseComponentValidator.class, new ChooseComponentValidator(
                getBean(ClientIdValidator.class),
                getBean(ComponentValidator.class)));
        beans.put(ShowOrderValidator.class, new ShowOrderValidator(
                getBean(ClientIdValidator.class)));
        beans.put(IdOrderValidator.class, new IdOrderValidator(
                getBean(ClientIdValidator.class)));

        beans.put(ClientService.class, new ClientService(
                getBean(Database.class),
                getBean(ClientOrderValidator.class)));
        beans.put(ChangePersonalDateService.class, new ChangePersonalDateService(
                getBean(Database.class),
                getBean(ChangePersonalDateValidator.class)));
        beans.put(ChangePersonalSizeService.class, new ChangePersonalSizeService(
                getBean(Database.class),
                getBean(ChangePersonalSizeValidator.class)));
        beans.put(ChangeComponentService.class, new ChangeComponentService(
                getBean(Database.class),
                getBean(ChooseComponentValidator.class)));
        beans.put(ShowOrderService.class, new ShowOrderService(
                getBean(Database.class),
                getBean(ShowOrderValidator.class)));
        beans.put(DeleteOrderService.class, new DeleteOrderService(
                getBean(Database.class),
                getBean(IdOrderValidator.class)));

        beans.put(OrderUIAction.class, new OrderUIAction(
                getBean(ClientService.class)));
        beans.put(ChangePersonalDateUIAction.class, new ChangePersonalDateUIAction(
                getBean(ChangePersonalDateService.class)));
        beans.put(ChangePersonalSizeUIAction.class, new ChangePersonalSizeUIAction(
                getBean(ChangePersonalSizeService.class)));
        beans.put(ChangeComponentsUIAction.class, new ChangeComponentsUIAction(
                getBean(ChangeComponentService.class)));
        beans.put(ShowOrderUIAction.class, new ShowOrderUIAction(
                getBean(ShowOrderService.class)));
        beans.put(DeleteOrderUIAction.class, new DeleteOrderUIAction(
                getBean(DeleteOrderService.class)));
        beans.put(ExitUIAction.class, new ExitUIAction());
    }

    public <T extends Object> T getBean(Class c) {
        return (T) beans.get(c);
    }

}
