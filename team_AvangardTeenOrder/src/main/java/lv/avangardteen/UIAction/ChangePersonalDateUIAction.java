package lv.avangardteen.UIAction;

import lv.avangardteen.core.request.ChangePersonalDateRequest;
import lv.avangardteen.core.responce.ChangePersonalDateResponse;
import lv.avangardteen.core.service.ChangePersonalDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.Scanner;

@Component
public class ChangePersonalDateUIAction implements UIAction {

    @Autowired
    ChangePersonalDateService service;

    @Override
    public void execute() {
        try {
            System.out.println("Введите номер заказа");
            Scanner scanner = new Scanner(System.in);
            Long id = scanner.nextLong();
            Scanner scan = new Scanner(System.in);
            System.out.println("Введите Имя и Фамилию");
            String nameSurname = scan.nextLine();
            System.out.println("Введите номер телефона");
            Long phoneNumber = scanner.nextLong();
            System.out.println("Введите свой адрес");
            String address = scan.nextLine();
            ChangePersonalDateRequest request = new ChangePersonalDateRequest(id, nameSurname, phoneNumber, address);
            ChangePersonalDateResponse response = service.execute(request);
            if (response.hasErrors()) {
                response.getErrors().forEach(coreError ->
                        System.out.println(("ErrorInputs: " + coreError.getField() + " " + coreError.getMessage())));
                System.out.println("Ваш выбор не сохранен");
            } else {
                System.out.println("Ваши данные сохранены");
            }
        } catch (InputMismatchException e) {
            System.out.println("Must input only digits!");
        }
    }
}
