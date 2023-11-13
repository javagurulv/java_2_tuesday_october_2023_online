package lv.javaguru.java2.cakeConstructor.newApp.console_ui;

import lv.javaguru.java2.cakeConstructor.newApp.core.request.SearchIngridientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.SearchIngridientResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.SearchIngridientsService;

import java.util.Scanner;

public class SearchIngridientsUIAction implements UIAction {

    private SearchIngridientsService service;

    public SearchIngridientsUIAction (SearchIngridientsService service){
        this.service=service;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter type of ingridient: ");
        String type = scanner.nextLine();
        System.out.println("Enter taste of ingridient: ");
        String taste = scanner.nextLine();

        SearchIngridientRequest request = new SearchIngridientRequest(type, taste);
        SearchIngridientResponse response = service.execute(request);

        if (response.hasErrors()) {
            response.getErrors().forEach(coreError -> System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage()));
        } else {
            response.getIngridients().forEach(System.out::println);
        }
    }
}
