package lv.javaguru.java2.product.storage;

import lv.javaguru.java2.product.storage.console_ui.AddProductUIAction;
import lv.javaguru.java2.product.storage.console_ui.ExitProgramUIAction;
import lv.javaguru.java2.product.storage.console_ui.PrintAllProductsUIAction;
import lv.javaguru.java2.product.storage.console_ui.RemoveProductUIAction;
import lv.javaguru.java2.product.storage.console_ui.SearchProductsUIAction;
import lv.javaguru.java2.product.storage.core.database.Database;
import lv.javaguru.java2.product.storage.core.database.InMemoryDatabaseImpl;
import lv.javaguru.java2.product.storage.core.services.AddProductService;
import lv.javaguru.java2.product.storage.core.services.GetAllProductsService;
import lv.javaguru.java2.product.storage.core.services.RemoveProductService;
import lv.javaguru.java2.product.storage.core.services.SearchProductsService;
import lv.javaguru.java2.product.storage.core.services.validators.AddProductRequestValidator;
import lv.javaguru.java2.product.storage.core.services.validators.OrderingValidator;
import lv.javaguru.java2.product.storage.core.services.validators.PagingValidator;
import lv.javaguru.java2.product.storage.core.services.validators.RemoveProductRequestValidator;
import lv.javaguru.java2.product.storage.core.services.validators.SearchProductsRequestFieldValidator;
import lv.javaguru.java2.product.storage.core.services.validators.SearchProductsRequestValidator;

import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {

    private Map<Class, Object> beans = new HashMap<>();

    public ApplicationContext() {
        beans.put(Database.class, new InMemoryDatabaseImpl());

        beans.put(AddProductRequestValidator.class, new AddProductRequestValidator());
        beans.put(RemoveProductRequestValidator.class, new RemoveProductRequestValidator());

        beans.put(SearchProductsRequestFieldValidator.class, new SearchProductsRequestFieldValidator());
        beans.put(OrderingValidator.class, new OrderingValidator());
        beans.put(PagingValidator.class, new PagingValidator());
        beans.put(SearchProductsRequestValidator.class, new SearchProductsRequestValidator(
                getBean(SearchProductsRequestFieldValidator.class),
                getBean(OrderingValidator.class),
                getBean(PagingValidator.class)
        ));

        beans.put(AddProductService.class, new AddProductService(
                getBean(Database.class),
                getBean(AddProductRequestValidator.class)));
        beans.put(RemoveProductService.class, new RemoveProductService(
                getBean(Database.class),
                getBean(RemoveProductRequestValidator.class)));
        beans.put(GetAllProductsService.class, new GetAllProductsService(getBean(Database.class)));
        beans.put(SearchProductsService.class, new SearchProductsService(
                getBean(Database.class),
                getBean(SearchProductsRequestValidator.class)));

        beans.put(AddProductUIAction.class, new AddProductUIAction(getBean(AddProductService.class)));
        beans.put(RemoveProductUIAction.class, new RemoveProductUIAction(getBean(RemoveProductService.class)));
        beans.put(PrintAllProductsUIAction.class, new PrintAllProductsUIAction(getBean(GetAllProductsService.class)));
        beans.put(ExitProgramUIAction.class, new ExitProgramUIAction());
        beans.put(SearchProductsUIAction.class, new SearchProductsUIAction(getBean(SearchProductsService.class)));
    }

    public <T extends Object> T getBean(Class c) { return (T) beans.get(c); }
}
