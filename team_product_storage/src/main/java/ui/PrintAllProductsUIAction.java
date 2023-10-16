package ui;

import domain.Product;
import services.GetAllProductsService;

public class PrintAllProductsUIAction {

    private GetAllProductsService service;

    public PrintAllProductsUIAction(GetAllProductsService service) {
        this.service = service;
    }

    public void execute() {
        System.out.println("All product list: ");
        for (Product product : service.getAllProducts()) {
            System.out.println(product);
        }
    }
}
