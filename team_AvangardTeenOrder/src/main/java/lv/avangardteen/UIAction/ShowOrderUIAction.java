package lv.avangardteen.UIAction;

import lv.avangardteen.core.request.ShowOrderRequest;
import lv.avangardteen.core.responce.ShowOrderResponse;
import lv.avangardteen.core.service.ShowOrderService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ShowOrderUIAction implements UIAction {
    ShowOrderService service;

    public ShowOrderUIAction(ShowOrderService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        try {
            System.out.println("Введите номер заказа");
            Scanner scanner = new Scanner(System.in);
            long id = scanner.nextLong();
            ShowOrderRequest orderRequest = new ShowOrderRequest(id);

        ShowOrderResponse response = service.execute(orderRequest);

        if (response.hasErrors()) {
            response.getErrors().forEach(coreError ->
                    System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage()));
        } else {
            System.out.println(response.getClient().toString());
        }
        } catch (InputMismatchException e) {
            System.out.println("Must input only digits!");
        }
    }
}

