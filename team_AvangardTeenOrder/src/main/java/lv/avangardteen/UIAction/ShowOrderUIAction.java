package lv.avangardteen.UIAction;

import lv.avangardteen.core.request.ShowOrderRequest;
import lv.avangardteen.core.service.ShowOrderService;

import java.util.Scanner;

public class ShowOrderUIAction {
    ShowOrderService service;

    public ShowOrderUIAction(ShowOrderService service) {
        this.service = service;
    }

    public void execute() {
        System.out.println("ВВедите персональный код id");
        Scanner scanner = new Scanner(System.in);
        long id = scanner.nextLong();
        ShowOrderRequest orderRequest = new ShowOrderRequest(id);
        service.execute(orderRequest);
    }
}

