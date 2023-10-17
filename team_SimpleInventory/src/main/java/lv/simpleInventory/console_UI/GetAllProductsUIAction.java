package lv.simpleInventory.console_UI;

import lv.simpleInventory.services.GetAllProductsService;

public class GetAllProductsUIAction implements UIAction {


    private GetAllProductsService getAllProductsService;


    public GetAllProductsUIAction(GetAllProductsService getAllProductsService) {
        this.getAllProductsService = getAllProductsService;

    }

    @Override
    public void execute() {

            System.out.println("PRODUCT LIST");
            getAllProductsService.execute().forEach(System.out::println);

    }
}
