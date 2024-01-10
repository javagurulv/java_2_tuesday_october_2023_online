package lv.javaguru.java2.product.storage.console_ui;

import lv.javaguru.java2.product.storage.core.requests.UpdateProductRequest;
import lv.javaguru.java2.product.storage.core.responses.UpdateProductResponse;
import lv.javaguru.java2.product.storage.core.services.UpdateProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Scanner;

@Component
public class UpdateProductUIAction implements UIAction {

    @Autowired private UpdateProductService updateProductService;


    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product id to update: ");
        Long productId = Long.parseLong(scanner.nextLine());
        System.out.println("Enter new product name: ");
        String newProductName = scanner.nextLine();
        System.out.println("Enter new product brand: ");
        String newProductBrand = scanner.nextLine();
        System.out.println("Enter new product model: ");
        String newProductModel = scanner.nextLine();
        System.out.println("Enter new product quantity: ");
        Integer newProductQuantity = scanner.nextInt();
        System.out.println("Enter new price: ");
        BigDecimal newPrice = scanner.nextBigDecimal();
        UpdateProductRequest request = new UpdateProductRequest(productId, newProductName, newProductBrand, newProductModel, newProductQuantity, newPrice);
        UpdateProductResponse response = updateProductService.execute(request);

        if (response.hasErrors()) {
            response.getErrors().forEach(coreError ->
                    System.out.println("Error: " + coreError.getErrorCode() + " " + coreError.getMessage())
            );
        } else {
            System.out.println("Your product was updated" + response.getUpdatedProduct());

        }
    }
}
