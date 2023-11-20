package fitness_club.dependency_injection;

import fitness_club.console_UI.*;
import fitness_club.core.database.Database;
import fitness_club.core.database.InFileDatabase;
import fitness_club.core.services.*;
import fitness_club.data_vlidation.*;

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
