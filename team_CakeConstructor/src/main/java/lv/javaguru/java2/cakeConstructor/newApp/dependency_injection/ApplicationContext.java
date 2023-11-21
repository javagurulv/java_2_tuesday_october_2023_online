package lv.javaguru.java2.cakeConstructor.newApp.dependency_injection;

import java.util.HashMap;
import java.util.Map;

import lv.javaguru.java2.cakeConstructor.newApp.console_ui.AddIngredientUIAction;
import lv.javaguru.java2.cakeConstructor.newApp.console_ui.GetAllIngredientsUIAction;
import lv.javaguru.java2.cakeConstructor.newApp.console_ui.RemoveIngredientUIAction;
import lv.javaguru.java2.cakeConstructor.newApp.console_ui.SearchIngredientsUIAction;
import lv.javaguru.java2.cakeConstructor.newApp.console_ui.ExitUIAction;
import lv.javaguru.java2.cakeConstructor.newApp.core.database.Database;
import lv.javaguru.java2.cakeConstructor.newApp.core.database.InMemoryDatabaseImpl;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.AddIngredientService;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.GetAllIngredientsService;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.RemoveIngredientService;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.SearchIngredientsService;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.validators.*;

public class ApplicationContext {

	private Map<Class, Object> beans = new HashMap<>();

	public ApplicationContext() { }

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

	public <T extends Object> T getBean(Class c) { return (T) beans.get(c); }

}


