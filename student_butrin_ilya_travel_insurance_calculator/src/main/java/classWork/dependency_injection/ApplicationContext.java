package classWork.dependency_injection;

import classWork.consoleUI.*;
import classWork.core.database.Database;
import classWork.core.database.InMemoryDatabaseImpl;
import classWork.core.service.AddBookService;
import classWork.core.service.GetAllBookService;
import classWork.core.service.RemoveBookService;
import classWork.core.service.SearchBooksService;
import classWork.core.service.valigators.*;

import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {

    private Map<Class, Object> beans = new HashMap<>();
    public ApplicationContext() { }

    public <T extends Object> T getBean(Class c) {
        return (T) beans.get(c);
    }
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
}
