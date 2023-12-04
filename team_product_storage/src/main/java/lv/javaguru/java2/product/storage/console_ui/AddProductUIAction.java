package lv.javaguru.java2.product.storage.console_ui;

import lv.javaguru.java2.product.storage.core.domain.Category;
import lv.javaguru.java2.product.storage.core.requests.AddProductRequest;
import lv.javaguru.java2.product.storage.core.responses.AddProductResponse;
import lv.javaguru.java2.product.storage.core.services.AddProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

@Component
public class AddProductUIAction implements UIAction {

    @Autowired
    private AddProductService addProductService;

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
        Integer productQuantity = getProductQuantity(scanner);
        System.out.println("Enter price in stock: ");
        BigDecimal priceInStock = getPriceInStock(scanner);

        System.out.println("Select product category:");
        Category[] categories = getCategoriesList();
        Category selectedCategory = getCategoryChoice(scanner, categories);

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


    private static BigDecimal getPriceInStock(Scanner scanner) {
        BigDecimal priceInStock = null;
        while (priceInStock == null) {
            try {
                priceInStock = scanner.nextBigDecimal();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer for the product price in stock.");
                scanner.next();
            }
        }
        return priceInStock;
    }

    private static Integer getProductQuantity(Scanner scanner) {
        Integer productQuantity = null;
        while (productQuantity == null) {
            try {
                productQuantity = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer for the product quantity.");
                scanner.next();
            }
        }
        return productQuantity;
    }


    private static Category[] getCategoriesList() {
        Category[] categories = Category.values();
        for (int i = 0; i < categories.length; i++) {
            System.out.println((i + 1) + ". " + categories[i]);
        }
        return categories;
    }


    private static Category getCategoryChoice(Scanner scanner, Category[] categories) {

        System.out.println("Enter the number corresponding to the desired category:");

        int choice = 0;
        while (true) {
            try {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= categories.length) {
                    Category selectedCategory = categories[choice - 1];
                    System.out.println("You selected: " + selectedCategory);
                    return selectedCategory;
                } else {
                    System.out.println("Please enter a valid category number.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid category number.");
                scanner.next();
            }
        }
    }
}