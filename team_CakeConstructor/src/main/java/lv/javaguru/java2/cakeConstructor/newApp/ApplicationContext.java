package lv.javaguru.java2.cakeConstructor.newApp;

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

	public ApplicationContext() {
		beans.put(Database.class, new InMemoryDatabaseImpl());

		beans.put(AddIngredientRequestValidator.class, new AddIngredientRequestValidator());
		beans.put(RemoveIngredientRequestValidator.class, new RemoveIngredientRequestValidator());

		beans.put(SearchIngredientsRequestFieldValidator.class, new SearchIngredientsRequestFieldValidator());
		beans.put(OrderingValidator.class, new OrderingValidator());
		beans.put(PagingValidator.class, new PagingValidator());
		beans.put(SearchIngredientsRequestValidator.class, new SearchIngredientsRequestValidator(
				getBean(SearchIngredientsRequestFieldValidator.class),
				getBean(OrderingValidator.class),
				getBean(PagingValidator.class)
		));

		beans.put(AddIngredientService.class, new AddIngredientService(
				getBean(Database.class),
				getBean(AddIngredientRequestValidator.class)));
		beans.put(RemoveIngredientService.class, new RemoveIngredientService(
				getBean(Database.class),
				getBean(RemoveIngredientRequestValidator.class)));
		beans.put(GetAllIngredientsService.class, new GetAllIngredientsService(getBean(Database.class)));
		beans.put(SearchIngredientsService.class, new SearchIngredientsService(
				getBean(Database.class),
				getBean(SearchIngredientsRequestValidator.class)));

		beans.put(AddIngredientUIAction.class, new AddIngredientUIAction(getBean(AddIngredientService.class)));
		beans.put(RemoveIngredientUIAction.class, new RemoveIngredientUIAction(getBean(RemoveIngredientService.class)));
		beans.put(GetAllIngredientsUIAction.class, new GetAllIngredientsUIAction(getBean(GetAllIngredientsService.class)));
		beans.put(ExitUIAction.class, new ExitUIAction());
		beans.put(SearchIngredientsUIAction.class, new SearchIngredientsUIAction(getBean(SearchIngredientsService.class)));
	}

	public <T extends Object> T getBean(Class c) { return (T) beans.get(c); }

}


