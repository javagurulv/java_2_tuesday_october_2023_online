package lv.javaguru.java2.cakeConstructor.newApp.console_ui;

import lv.javaguru.java2.cakeConstructor.newApp.core.requests.GetAllClientsRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.GetAllClientsResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.services.GetAllClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrintAllClientsUIAction implements UIAction {

    @Autowired private GetAllClientsService getAllClientsService;

    @Override
    public void execute() {
        System.out.println("Client list: ");
        GetAllClientsRequest request = new GetAllClientsRequest();
        GetAllClientsResponse response = getAllClientsService.execute(request);
        response.getClients().forEach(System.out::println);
        System.out.println("Client list end.");
    }
}
