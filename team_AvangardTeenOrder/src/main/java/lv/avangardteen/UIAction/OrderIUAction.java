package lv.avangardteen.UIAction;

import lv.avangardteen.core.request.ClientRequest;
import lv.avangardteen.core.service.OrderCalculateServiceImpl;
import lv.avangardteen.data.DataComponents;

import java.util.Scanner;

public class OrderIUAction implements UIAction {
    DataComponents dataComponents = new DataComponents();
    OrderCalculateServiceImpl service;
    public OrderIUAction( OrderCalculateServiceImpl service) {

        this.service = service;
    }

    @Override
    public void execute() {
        Scanner scan = new Scanner(System.in);
        System.out.println("ВВедите персональный номер ID");
        long id = scan.nextLong();
        Scanner scan1 = new Scanner(System.in);
        System.out.println("введите Имя и Фамилию");
        String nameSurname = scan1.nextLine();
        System.out.println("введите номер телефона");
        String phoneNumber = scan1.nextLine();
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
        System.out.println("Введите маркировку тип и размер передних колес коляски");
        String wheelFrom = scanner.nextLine();
        System.out.println(dataComponents.allBackWheels().toString());
        System.out.println("Введите маркировку тип и размер задних колес коляски");
        String wheelBack = scanner.nextLine();
        System.out.println(dataComponents.allBrakes().toString());
        System.out.println("Введите марку выбранных тормозов");
        String brakeChoose = scanner.nextLine();
        System.out.println(dataComponents.allArmrest().toString());
        System.out.println("Введите марку выбранных подлокотников");
        String armrestChoose = scanner.nextLine();
        ClientRequest request = new ClientRequest(id, nameSurname, phoneNumber, userAddress,
        shinLength, backLength, thighLength, pelvisWidth,
        wheelFrom, wheelBack, brakeChoose, armrestChoose);
        service.execute(request);

    }
}
