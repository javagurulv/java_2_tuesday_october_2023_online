package lv.javaguru.java2.cakeConstructor.newApp.console_ui;
import lv.javaguru.java2.cakeConstructor.newApp.core.requests.GetAllIngredientsRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.GetAllIngredientsResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.GetAllIngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetAllIngredientsUIAction implements UIAction{

    @Autowired private GetAllIngredientsService getAllIngredientsService;


    @Override
    public void execute() {
        System.out.println("Ingredient list: ");
        GetAllIngredientsRequest request = new GetAllIngredientsRequest();
        GetAllIngredientsResponse response = getAllIngredientsService.execute(request);
        response.getIngredients().forEach(System.out::println);
        System.out.println("Ingredient list end.");
    }
}
