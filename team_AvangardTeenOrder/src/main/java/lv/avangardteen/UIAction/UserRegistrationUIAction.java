package lv.avangardteen.UIAction;

import lv.avangardteen.core.request.UserRegistrationRequest;
import lv.avangardteen.core.responce.UserRegistrationResponse;
import lv.avangardteen.core.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.Scanner;

@Component
public class UserRegistrationUIAction implements UIAction {

    @Autowired
    private UserRegistrationService service;

    @Override
    public void execute() {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Введите Имя и Фамилию");
            String nameSurname = scan.nextLine();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите номер телефона");
            Long phoneNumber = scanner.nextLong();
            System.out.println("Введите свой адрес");
            String address = scan.nextLine();
            UserRegistrationRequest request = new UserRegistrationRequest(nameSurname, phoneNumber, address);
            UserRegistrationResponse response = service.execute(request);
            if (response.hasErrors()) {
                response.getErrors().forEach(coreError ->
                        System.out.println(("ErrorInputs: " + coreError.getField() + " " + coreError.getMessage())));
                System.out.println("Ваши данные не сохранены");
            } else {
                System.out.println("Ваши данные сохранены");
            }
        } catch (InputMismatchException e) {
            System.out.println("Must input only digits!");
        }
    }
}

