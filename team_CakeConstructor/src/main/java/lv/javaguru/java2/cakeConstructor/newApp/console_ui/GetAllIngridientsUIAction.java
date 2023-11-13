package lv.javaguru.java2.cakeConstructor.newApp.console_ui;
import lv.javaguru.java2.cakeConstructor.newApp.core.request.GetAllIngridientsRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.GetAllIngridientsResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.GetAllIngridientsService;

public class GetAllIngridientsUIAction implements UIAction{

    private GetAllIngridientsService service;

    public GetAllIngridientsUIAction (GetAllIngridientsService service){
        this.service=service;
    }
    @Override
    public void execute() {
        System.out.println("Ingridient list: ");
        GetAllIngridientsRequest request = new GetAllIngridientsRequest();
        GetAllIngridientsResponse response = service.execute(request);
        response.getIngridients().forEach(System.out::println);
        System.out.println("Ingridient list end.");
    }
}
