package lv.javaguru.java2.product.storage.ui;

import lv.javaguru.java2.product.storage.core.domain.Product;
import lv.javaguru.java2.product.storage.core.requests.GetAllProductsRequest;
import lv.javaguru.java2.product.storage.core.responses.GetAllProductsResponse;
import lv.javaguru.java2.product.storage.core.services.GetAllProductsService;

public class PrintAllProductsUIAction implements UIAction {

    private GetAllProductsService getAllProductsService;

    public PrintAllProductsUIAction(GetAllProductsService getAllProductsService) {
        this.getAllProductsService = getAllProductsService;
    }

    @Override
    public void execute() {
        System.out.println("All product list: ");
        GetAllProductsRequest request = new GetAllProductsRequest();
        GetAllProductsResponse response = getAllProductsService.execute(request);
        response.getProducts().forEach(System.out::println);
        System.out.println("Product list end.");
    }
}
