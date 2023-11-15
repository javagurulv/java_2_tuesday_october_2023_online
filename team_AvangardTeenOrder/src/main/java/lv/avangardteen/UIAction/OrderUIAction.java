package lv.avangardteen.UIAction;

import lv.avangardteen.core.request.ClientRequest;
import lv.avangardteen.core.responce.ClientResponse;
import lv.avangardteen.core.service.ClientService;
import lv.avangardteen.data.DataComponents;
import lv.avangardteen.dependency_injection.DIComponent;
import lv.avangardteen.dependency_injection.DIDependency;

import java.util.InputMismatchException;
import java.util.Scanner;

@DIComponent
public class OrderUIAction implements UIAction {
    @DIDependency
    DataComponents dataComponents;
    @DIDependency
    ClientService service;

    @Override
    public void execute() {
        try {
            Scanner scan1 = new Scanner(System.in);
            System.out.println("введите Имя и Фамилию");
            String nameSurname = scan1.nextLine();
            Scanner scan3 = new Scanner(System.in);
            System.out.println("введите номер телефона, по которому можно утонить время доставки");
            Integer phoneNumber = scan3.nextInt();
            System.out.println("введите свой адрес");
            String userAddress = scan1.nextLine();
            Scanner scan2 = new Scanner(System.in);
            System.out.println("введите ширину таза пользователя");
            Integer pelvisWidth = scan2.nextInt();
            System.out.println("введите длину бедра пользователя");
            Integer thighLength = scan2.nextInt();
            System.out.println("введите длину спины пользователя до нижнего края лопатки");
            Integer backLength = scan2.nextInt();
            System.out.println("введите длину голени пользователя");
            Integer shinLength = scan2.nextInt();
            System.out.println("Выберите комплектующие инвалидного кресла Avangard Teen");
            Scanner scanner = new Scanner(System.in);
            System.out.println(dataComponents.allFrontWheels().toString());
            System.out.println("Введите индекс передних колес коляски");
            Integer wheelFrom = scanner.nextInt();
            System.out.println(dataComponents.allBackWheels().toString());
            System.out.println("Введите индекс задних колес коляски");
            Integer wheelBack = scanner.nextInt();
            System.out.println(dataComponents.allBrakes().toString());
            System.out.println("Введите индекс выбранных тормозов");
            Integer brakeChoose = scanner.nextInt();
            System.out.println(dataComponents.allArmrest().toString());
            System.out.println("Введите индекс выбранных подлокотников");
            Integer armrestChoose = scanner.nextInt();
            ClientRequest request = new ClientRequest(nameSurname, phoneNumber, userAddress,
                    shinLength, backLength, thighLength, pelvisWidth,
                    wheelFrom, wheelBack, brakeChoose, armrestChoose);
            ClientResponse response = service.execute(request);

            if (response.hasErrors()) {
                response.getErrors().forEach(coreError ->
                        System.out.println("Error: " + coreError.getField() + " " + coreError.getMessage()));
                System.out.println("Вы не заполнили заказ полностью. Будьте внимательны!");
            } else {
                System.out.println("Ваш номер заказа " + response.getClient().getId());
                System.out.println(response.getClient().toString());
            }
        } catch (InputMismatchException e) {
            System.out.println("Must input only digits!");
        }

    }
}
