package ui;

import domain.Product;
import services.GetAllProductsService;

public class PrintAllProductsUIAction implements UIAction {

    private GetAllProductsService getAllProductsService;

    public PrintAllProductsUIAction(GetAllProductsService getAllProductsService) {
        this.getAllProductsService = getAllProductsService;
    }

    @Override
    public void execute() {
        System.out.println("All product list: ");
        for (Product product : getAllProductsService.execute()) {
            System.out.println(product);
        }
    }
}
