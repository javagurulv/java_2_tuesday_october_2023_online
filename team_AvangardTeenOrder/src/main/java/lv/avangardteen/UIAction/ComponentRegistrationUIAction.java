package lv.avangardteen.UIAction;

import lv.avangardteen.core.data.DataComponents;
import lv.avangardteen.core.data.Database;
import lv.avangardteen.core.request.ChangeComponentRequest;
import lv.avangardteen.core.request.ComponentRegistrationRequest;
import lv.avangardteen.core.responce.ChangeComponentResponse;
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
            ComponentRegistrationRequest request = new ComponentRegistrationRequest(wheelFront, wheelBack,
                    brake, armrest);
            ComponentRegistrationResponse response = service.execute(request);

            if (response.hasErrors()) {
                response.getErrors().forEach(coreError ->
                        System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage()));
                System.out.println("Ваш выбор не сохранен");
            } else {
                System.out.println("Ваш выбор сохранен");
                System.out.println("Номер вашего заказа" + response.getWheelchairComponent().getId());
            }
        } catch (InputMismatchException e) {
            System.out.println("Must input only digits!");
        }

    }
}

