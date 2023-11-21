package lv.javaguru.java2.cakeConstructor.newApp.console_ui;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.GetAllIngredientsRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.GetAllIngredientsResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.GetAllIngredientsService;

public class GetAllIngredientsUIAction implements UIAction{

    private GetAllIngredientsService getAllIngredientsService;

    public GetAllIngredientsUIAction(GetAllIngredientsService getAllIngredientsService) {
        this.getAllIngredientsService = getAllIngredientsService;
    }

    @Override
    public void execute() {
        System.out.println("Ingredient list: ");
        GetAllIngredientsRequest request = new GetAllIngredientsRequest();
        GetAllIngredientsResponse response = getAllIngredientsService.execute(request);
        response.getIngredients().forEach(System.out::println);
        System.out.println("Ingredient list end.");
    }
}
