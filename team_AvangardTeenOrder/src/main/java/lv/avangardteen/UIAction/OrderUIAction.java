package lv.avangardteen.UIAction;

import lv.avangardteen.core.request.ClientRequest;
import lv.avangardteen.core.service.ClientService;
import lv.avangardteen.data.DataComponents;

import java.util.Scanner;

public class OrderUIAction implements UIAction {
    DataComponents dataComponents = new DataComponents();
    ClientService service;
    public OrderUIAction(ClientService service) {

        this.service = service;
    }

    @Override
    public void execute() {

        Scanner scan1 = new Scanner(System.in);
        System.out.println("введите Имя и Фамилию");
        String nameSurname = scan1.nextLine();
        Scanner scan3 = new Scanner(System.in);
        System.out.println("введите номер телефона");
        int phoneNumber = scan3.nextInt();
        System.out.println("введите свой адрес");
        String userAddress = scan1.nextLine();
        Scanner scan2 = new Scanner(System.in);
        System.out.println("введите длину голени пользователя");
        int shinLength = scan2.nextInt();
        System.out.println("введите длину спины пользователя до нижнего края лопатки");
        int backLength = scan2.nextInt();
        System.out.println("введите длину бедра пользователя");
        int thighLength = scan2.nextInt();
        System.out.println("введите ширину таза пользователя");
        int pelvisWidth = scan2.nextInt();
        System.out.println("Выберите комплектующие инвалидного кресла Avangard Teen");
        Scanner scanner = new Scanner(System.in);
        System.out.println(dataComponents.allFrontWheels().toString());
        System.out.println("Введите индекс передних колес коляски");
        int wheelFrom = scanner.nextInt();
        System.out.println(dataComponents.allBackWheels().toString());
        System.out.println("Введите индекс задних колес коляски");
        int wheelBack = scanner.nextInt();
        System.out.println(dataComponents.allBrakes().toString());
        System.out.println("Введите индекс выбранных тормозов");
        int brakeChoose = scanner.nextInt();
        System.out.println(dataComponents.allArmrest().toString());
        System.out.println("Введите индекс выбранных подлокотников");
        int armrestChoose = scanner.nextInt();
        ClientRequest request = new ClientRequest(nameSurname, phoneNumber, userAddress,
                shinLength, backLength, thighLength, pelvisWidth,
                wheelFrom, wheelBack, brakeChoose, armrestChoose);
        service.execute(request);

    }
}
