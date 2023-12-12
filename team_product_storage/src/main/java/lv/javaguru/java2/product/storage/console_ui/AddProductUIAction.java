package lv.javaguru.java2.product.storage.console_ui;

import lv.javaguru.java2.product.storage.core.domain.Category;
import lv.javaguru.java2.product.storage.core.requests.AddProductRequest;
import lv.javaguru.java2.product.storage.core.responses.AddProductResponse;
import lv.javaguru.java2.product.storage.core.services.AddProductService;
import lv.javaguru.java2.product.storage.core.services.GetCategoriesListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

@Component
public class AddProductUIAction implements UIAction {

    @Autowired
    private AddProductService addProductService;
    @Autowired
    private GetCategoriesListService getCategoriesListService;
    @Autowired
    private GetCategoryChoice getCategoryChoice;

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product name: ");
        String productName = scanner.nextLine();
        System.out.println("Enter product brand: ");
        String productBrand = scanner.nextLine();
        System.out.println("Enter product model: ");
        String productModel = scanner.nextLine();
        System.out.println("Enter product quantity: ");
        Integer productQuantity = scanner.nextInt();
        System.out.println("Enter price in stock: ");
        BigDecimal priceInStock = scanner.nextBigDecimal();
        System.out.println("Select product category:");
        List<String> categories = getCategoriesListService.getCategoriesList();
        Category selectedCategory = getCategoryChoice.getCategoryChoice(scanner, categories);

        AddProductRequest request = new AddProductRequest(productName, productBrand, productModel, productQuantity, priceInStock, selectedCategory);
        AddProductResponse response = addProductService.execute(request);
        if (response.hasErrors()) {
            response.getErrors().forEach(coreError ->
                    System.out.println("Error: " + coreError.getErrorCode() + " " + coreError.getMessage())
            );
        } else {
            System.out.println("New product id was: " + response.getNewProduct().getId());
            System.out.println("Your product was added to list.");
        }
    }

}