package lv.avangardteen.UIAction;
/*

import lv.avangardteen.core.database.DataComponents;
import lv.avangardteen.core.request.ChangeComponentRequest;
import lv.avangardteen.core.responce.ChangeComponentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.InputMismatchException;
import java.util.Scanner;

@Component
@Transactional
public class ChangeComponentsUIAction implements UIAction {

    @Autowired
    private DataComponents dataComponents;
    @Autowired
    private ChangeComponentService service;


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


*/
