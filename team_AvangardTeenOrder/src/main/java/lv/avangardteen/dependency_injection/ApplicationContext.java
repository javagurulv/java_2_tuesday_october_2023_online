package lv.avangardteen.dependency_injection;

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
    public void addBean(Class beanClass, Object beanInstance) {
        beans.put(beanClass, beanInstance);
        Class[] instanceInterfaces = beanClass.getInterfaces();
        for (int i = 0; i < instanceInterfaces.length; i++) {
            Class instanceInterface = instanceInterfaces[i];
            Object instance = getBean(instanceInterface);
            if (instance == null) {
                beans.put(instanceInterface, beanInstance);
            }
        }
    }

    public <T extends Object> T getBean(Class c) {
        return (T) beans.get(c);
    }

}
