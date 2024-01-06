package lv.avangardteen.UIAction;

import lv.avangardteen.core.request.OrderRequest;
import lv.avangardteen.core.responce.OrderResponse;
import lv.avangardteen.core.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.Scanner;

@Component
public class OrderUIAction implements UIAction{

    @Autowired
    private OrderService service;

    @Override
    public void execute() {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Введите Имя и Фамилию");
            String userName = scan.nextLine();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите персональный код");
            Long userPersonalCode = scanner.nextLong();
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Введите ширину таза (cм)");
            Integer pelvisWidth = scanner1.nextInt();

            System.out.println("Введите длину бедра (см)");
            Integer thighLength = scanner1.nextInt();

            System.out.println("Введите высоту спины (см)");
            Integer backHeight = scanner1.nextInt();

            System.out.println("Введите длину голени (см)");
            Integer shinLength = scanner.nextInt();
            OrderRequest request = new OrderRequest(userName,
             userPersonalCode, pelvisWidth, thighLength,
                    backHeight, shinLength);
            OrderResponse response = service.execute(request);
            if (response.hasErrors()) {
                response.getErrors().forEach(coreError ->
                        System.out.println(("ErrorInputs: " + coreError.getField() + " " + coreError.getMessage())));
                System.out.println("Введенные данные не сохранены");
            } else {
                System.out.println("Введенные данные сохранены");
                System.out.println("Ваш номер заказа " + response.getIdOrder());
            }
        } catch (InputMismatchException e) {
            System.out.println("Must input only digits!");
        }
    }
}
