package lv.javaguru.java2.cakeConstructor.newApp.console_ui;

import lv.javaguru.java2.cakeConstructor.newApp.core.requests.Ordering;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.Paging;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.SearchIngredientsRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.SearchIngredientsResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.SearchIngredientsService;

import java.util.Scanner;

public class SearchIngredientsUIAction implements UIAction {

    private SearchIngredientsService searchIngredientsService;

    public SearchIngredientsUIAction(SearchIngredientsService searchIngredientsService) {
        this.searchIngredientsService = searchIngredientsService;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ingredient type: ");
        String type = scanner.nextLine();
        System.out.println("Enter ingredient taste: ");
        String taste = scanner.nextLine();

        System.out.println("Enter orderBy (type||taste): ");
        String orderBy = scanner.nextLine();
        System.out.println("Enter orderDirection (ASCENDING||DESCENDING): ");
        String orderDirection = scanner.nextLine();
        Ordering ordering = new Ordering(orderBy, orderDirection);

        System.out.println("Enter pageNumber: ");
        Integer pageNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter pageSize: ");
        Integer pageSize = Integer.parseInt(scanner.nextLine());
        Paging paging = new Paging(pageNumber, pageSize);

        SearchIngredientsRequest request = new SearchIngredientsRequest(type, taste, ordering, paging);
        SearchIngredientsResponse response = searchIngredientsService.execute(request);

        if (response.hasErrors()) {
            response.getErrors().forEach(coreError -> System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage()));
        } else {
            response.getIngredients().forEach(System.out::println);
        }
    }

}
