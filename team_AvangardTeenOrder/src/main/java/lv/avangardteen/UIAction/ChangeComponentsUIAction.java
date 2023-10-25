package lv.avangardteen.UIAction;

import lv.avangardteen.core.request.ChangeComponentRequest;
import lv.avangardteen.core.service.ChangeComponentService;
import lv.avangardteen.data.DataComponents;
import lv.avangardteen.data.DataOrders;

import java.util.Scanner;

public class ChangeComponentsUIAction implements UIAction {
    DataOrders dataOrders;
    DataComponents dataComponents = new DataComponents();
    ChangeComponentService service;

    public ChangeComponentsUIAction(ChangeComponentService service) {
        this.service = service;
    }


    @Override
    public void execute() {
        System.out.println("Введите номер заказа");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        System.out.println(dataComponents.allFrontWheels().toString());
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите маркировку тип и размер передних колес коляски");
        String wheelFront = scan.nextLine();
        System.out.println(dataComponents.allBackWheels().toString());
        System.out.println("Введите маркировку тип и размер задних колес коляски");
        String wheelBack = scan.nextLine();
        System.out.println(dataComponents.allBrakes().toString());
        System.out.println("Введите марку выбранных тормозов");
        String brake = scan.nextLine();
        System.out.println(dataComponents.allArmrest().toString());
        System.out.println("Введите марку выбранных подлокотников");
        String armrest = scan.nextLine();
        ChangeComponentRequest request = new ChangeComponentRequest(id, wheelFront, wheelBack,
                brake, armrest);
        service.execute(request);

    }
}


