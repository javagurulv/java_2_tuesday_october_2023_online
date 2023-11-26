package lv.javaguru.java2.product.storage.console_ui;

import lv.javaguru.java2.product.storage.core.requests.GetAllProductsRequest;
import lv.javaguru.java2.product.storage.core.responses.GetAllProductsResponse;
import lv.javaguru.java2.product.storage.core.services.GetAllProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrintAllProductsUIAction implements UIAction {

    @Autowired
    private GetAllProductsService getAllProductsService;

    @Override
    public void execute() {
        System.out.println("All product list: ");
        GetAllProductsRequest request = new GetAllProductsRequest();
        GetAllProductsResponse response = getAllProductsService.execute(request);
        response.getProducts().forEach(System.out::println);
        System.out.println("Product list end.");
    }
}
