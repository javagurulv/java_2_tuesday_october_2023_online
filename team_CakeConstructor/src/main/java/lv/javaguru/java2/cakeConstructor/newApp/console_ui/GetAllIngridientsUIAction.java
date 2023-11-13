package lv.javaguru.java2.cakeConstructor.newApp.console_ui;
import lv.javaguru.java2.cakeConstructor.newApp.database.DatabaseImpl;
import lv.javaguru.java2.cakeConstructor.newApp.database.Ingridient;
import lv.javaguru.java2.cakeConstructor.newApp.services.GetAllIngridientsService;

public class GetAllIngridientsUIAction implements UIAction{

    private GetAllIngridientsService service;

    public GetAllIngridientsUIAction (GetAllIngridientsService service){
        this.service=service;
    }
    @Override
    public void execute() {
        System.out.println("Ingridient list: ");
        service.execute().forEach(System.out::println);
        System.out.println("Ingridient list end.");
    }
}
