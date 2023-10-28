package lv.avangardteen.UIAction;

import lv.avangardteen.Client;
import lv.avangardteen.core.request.ShowOrderRequest;
import lv.avangardteen.core.service.ShowOrderService;

import java.util.Scanner;

public class ShowOrderUIAction implements UIAction {
    ShowOrderService service;

    public ShowOrderUIAction(ShowOrderService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        System.out.println("Введите номер заказа");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        ShowOrderRequest orderRequest = new ShowOrderRequest(id);
        Client client = service.execute(orderRequest).getClient();
        System.out.println(client.toString());
    }
}

