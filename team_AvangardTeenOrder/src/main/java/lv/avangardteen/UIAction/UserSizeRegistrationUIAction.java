package lv.avangardteen.UIAction;

import lv.avangardteen.core.request.ChangePersonalSizeRequest;
import lv.avangardteen.core.request.UserSizeRegistrationRequest;
import lv.avangardteen.core.responce.ChangePersonalSizeResponse;
import lv.avangardteen.core.responce.UserSizeRegistrationResponse;
import lv.avangardteen.core.service.UserSizeRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.Scanner;

@Component
public class UserSizeRegistrationUIAction implements UIAction{

    @Autowired
    private UserSizeRegistrationService service;

    @Override
    public void execute() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите ширину таза (cм)");
            Integer pelvisWidth = scanner.nextInt();

            System.out.println("Введите длину бедра (см)");
            Integer thighLength = scanner.nextInt();

            System.out.println("Введите высоту спины (см)");
            Integer backHeight = scanner.nextInt();

            System.out.println("Введите длину голени (см)");
            Integer shinLength = scanner.nextInt();
            UserSizeRegistrationRequest request = new UserSizeRegistrationRequest(pelvisWidth, thighLength,
                    backHeight, shinLength);
            UserSizeRegistrationResponse response = service.execute(request);
            if (response.hasErrors()) {
                response.getErrors().forEach(coreError ->
                        System.out.println(("ErrorInputs: " + coreError.getField() + " " + coreError.getMessage())));
                System.out.println("Введенные данные не сохранены");
            } else {
                System.out.println("Введенные данные сохранены");
            }
        } catch (InputMismatchException e) {
            System.out.println("Must input only digits!");
        }
    }
}
