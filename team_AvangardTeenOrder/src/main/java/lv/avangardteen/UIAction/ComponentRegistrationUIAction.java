package lv.avangardteen.UIAction;

import lv.avangardteen.core.database.DataComponents;
import lv.avangardteen.core.database.WComponentsDB;
import lv.avangardteen.core.database.WheelchairDB;
import lv.avangardteen.core.database.WheelchairRepository;
import lv.avangardteen.core.request.ComponentRegistrationRequest;
import lv.avangardteen.core.responce.ComponentRegistrationResponse;
import lv.avangardteen.core.service.ComponentRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.Scanner;

@Component
public class ComponentRegistrationUIAction implements UIAction {
    @Autowired
    private DataComponents dataComponents;
    @Autowired
    private ComponentRegistrationService service;

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
            System.out.println(dataComponents.allFootrest().toString());
            System.out.println("Введите индекс выбранной подножки");
            Integer footrest = scan.nextInt();
            ComponentRegistrationRequest request = new ComponentRegistrationRequest(id, wheelFront, wheelBack,
                    brake, footrest);
            ComponentRegistrationResponse response = service.execute(request);

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

