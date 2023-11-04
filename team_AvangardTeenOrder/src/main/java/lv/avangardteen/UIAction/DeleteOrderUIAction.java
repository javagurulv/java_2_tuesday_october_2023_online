package lv.avangardteen.UIAction;

import lv.avangardteen.Client;
import lv.avangardteen.core.request.DeleteOrderRequest;
import lv.avangardteen.core.request.ShowOrderRequest;
import lv.avangardteen.core.responce.DeleteOrderResponse;
import lv.avangardteen.core.service.DeleteOrderService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DeleteOrderUIAction implements UIAction{

    DeleteOrderService service;

    public DeleteOrderUIAction(DeleteOrderService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        try {


        System.out.println("Введите номер заказа");
        Scanner scanner = new Scanner(System.in);
        long id = scanner.nextLong();
        DeleteOrderRequest request = new DeleteOrderRequest(id);
        DeleteOrderResponse response = service.execute(request);


        if (response.hasErrors()) {
            response.getErrors().forEach(coreError ->
                    System.out.println("ErrorInput: " + coreError.getField() + " " + coreError.getMessage()));
        }
        if (response.isOrderRemoved()) {
            System.out.println("Ваш заказ удален.");
        } else {
            System.out.println("Ваш заказ не удален");

        }
        } catch (InputMismatchException e) {
            System.out.println("Must input only digits!");
        }

    }
}

