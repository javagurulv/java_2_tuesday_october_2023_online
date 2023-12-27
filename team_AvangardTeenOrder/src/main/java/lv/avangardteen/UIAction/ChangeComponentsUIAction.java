package lv.avangardteen.UIAction;

import lv.avangardteen.core.data.DataComponents;
import lv.avangardteen.core.request.ChangeComponentRequest;
import lv.avangardteen.core.responce.ChangeComponentResponse;
import lv.avangardteen.core.service.ChangeComponentService;
import lv.avangardteen.core.data.DataComponentsImpl;
import lv.avangardteen.core.data.DataOrders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.Scanner;

@Component
public class ChangeComponentsUIAction implements UIAction {
    @Autowired
    DataOrders dataOrders;
    @Autowired
    DataComponents dataComponents;
    @Autowired
    ChangeComponentService service;


    @Override
    public void execute() {
        try {


            System.out.println("Введите номер заказа");
            Scanner scanner = new Scanner(System.in);
            long id = scanner.nextLong();
            System.out.println(dataComponents.allFrontWheels().toString());
            Scanner scan = new Scanner(System.in);
            System.out.println("Введите индекс передних колес коляски");
            Integer wheelFront = scan.nextInt();
            System.out.println(dataComponents.allBackWheels().toString());
            System.out.println("Введите индекс задних колес коляски");
            Integer wheelBack = scan.nextInt();
            System.out.println(dataComponents.allBrakes().toString());
            System.out.println("Введите индекс выбранных тормозов");
            Integer brake = scan.nextInt();
            System.out.println(dataComponents.allArmrest().toString());
            System.out.println("Введите индекс выбранной подножки");
            Integer armrest = scan.nextInt();
            ChangeComponentRequest request = new ChangeComponentRequest(id, wheelFront, wheelBack,
                    brake, armrest);
            ChangeComponentResponse response = service.execute(request);

            if (response.hasErrors()) {
                response.getErrors().forEach(coreError ->
                        System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage()));
                System.out.println("Ваш выбор не сохранен");
            } else {
                System.out.println("Ваш выбор сохранен");
            }
        } catch (InputMismatchException e) {
            System.out.println("Must input only digits!");
        }

    }
}


