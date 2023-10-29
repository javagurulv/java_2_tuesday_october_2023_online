package lv.javaguru.java2.product.storage.console_ui;

import lv.javaguru.java2.product.storage.core.requests.Ordering;
import lv.javaguru.java2.product.storage.core.requests.Paging;
import lv.javaguru.java2.product.storage.core.requests.SearchProductsRequest;
import lv.javaguru.java2.product.storage.core.responses.SearchProductsResponse;
import lv.javaguru.java2.product.storage.core.services.SearchProductsService;

import java.util.Scanner;

public class SearchProductsUIAction implements UIAction {

    private SearchProductsService searchProductsService;

    public SearchProductsUIAction(SearchProductsService searchProductsService) {
        this.searchProductsService = searchProductsService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product brand: ");
        String productBrand = scanner.nextLine();
        System.out.println("Enter product model: ");
        String productModel = scanner.nextLine();

        System.out.println("Enter orderBy (productBrand||productModel): ");
        String orderBy = scanner.nextLine();
        System.out.println("Enter orderDirection (ASCENDING||DESCENDING): ");
        String orderDirection = scanner.nextLine();
        Ordering ordering = new Ordering(orderBy, orderDirection);

        System.out.println("Enter pageNumber: ");
        Integer pageNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter pageSize: ");
        Integer pageSize = Integer.parseInt(scanner.nextLine());
        Paging paging = new Paging(pageNumber, pageSize);

        SearchProductsRequest request = new SearchProductsRequest(productBrand, productModel, ordering, paging);
        SearchProductsResponse response = searchProductsService.execute(request);

        if (response.hasErrors()) {
            response.getErrors().forEach(coreError -> System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage()));
        } else {
            response.getProducts().forEach(System.out::println);
        }
    }
}
