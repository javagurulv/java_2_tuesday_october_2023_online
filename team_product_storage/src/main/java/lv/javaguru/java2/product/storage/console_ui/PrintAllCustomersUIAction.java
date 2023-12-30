package lv.javaguru.java2.product.storage.console_ui;

import lv.javaguru.java2.product.storage.core.requests.GetAllCustomersRequest;
import lv.javaguru.java2.product.storage.core.responses.GetAllCustomersResponse;
import lv.javaguru.java2.product.storage.core.services.GetAllCustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrintAllCustomersUIAction implements UIAction {

    @Autowired private GetAllCustomersService getAllCustomersService;

    @Override
    public void execute() {
        System.out.println("Customer list: ");
        GetAllCustomersRequest request = new GetAllCustomersRequest();
        GetAllCustomersResponse response = getAllCustomersService.execute(request);
        response.getCustomers().forEach(System.out::println);
        System.out.println("Customer list end.");
    }
}
