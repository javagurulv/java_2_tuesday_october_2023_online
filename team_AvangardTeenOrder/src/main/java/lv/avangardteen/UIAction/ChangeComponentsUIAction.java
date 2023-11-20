package lv.avangardteen.UIAction;

import lv.avangardteen.core.request.ChangeComponentRequest;
import lv.avangardteen.core.responce.ChangeComponentResponse;
import lv.avangardteen.core.service.ChangeComponentService;
import lv.avangardteen.data.DataComponents;
import lv.avangardteen.data.DataOrders;
import lv.avangardteen.dependency_injection.DIComponent;
import lv.avangardteen.dependency_injection.DIDependency;

import java.util.InputMismatchException;
import java.util.Scanner;

@DIComponent
public class ChangeComponentsUIAction implements UIAction {
    @DIDependency
    DataOrders dataOrders;
    @DIDependency
    DataComponents dataComponents;
    @DIDependency
    ChangeComponentService service;


    @Override
    public void execute() {
        try {


            System.out.println("Введите номер заказа");
            Scanner scanner = new Scanner(System.in);
            long id = scanner.nextLong();
            System.out.println(dataComponents.allFrontWheels().toString());
            Scanner scan = new Scanner(System.in);
            System.out.println("Введите маркировку тип и размер передних колес коляски");
            Integer wheelFront = scan.nextInt();
            System.out.println(dataComponents.allBackWheels().toString());
            System.out.println("Введите маркировку тип и размер задних колес коляски");
            Integer wheelBack = scan.nextInt();
            System.out.println(dataComponents.allBrakes().toString());
            System.out.println("Введите марку выбранных тормозов");
            Integer brake = scan.nextInt();
            System.out.println(dataComponents.allArmrest().toString());
            System.out.println("Введите марку выбранных подлокотников");
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


