package lv.avangardteen;

import lv.avangardteen.UIAction.*;
import lv.avangardteen.core.service.*;
import lv.avangardteen.data.DataOrders;

import java.util.Scanner;

public class OrderApplication {

    private static DataOrders dataOrders = new DataOrders();
    private static ClientOrderValidator orderValidator = new ClientOrderValidator();
    private static ChangePersonalDateValidator dateValidator = new ChangePersonalDateValidator();
    private static ChangePersonalSizeValidator sizeValidator = new ChangePersonalSizeValidator();
    private static ChooseComponentValidator componentValidator = new ChooseComponentValidator();
    private static ShowOrderValidator showOrderValidator = new ShowOrderValidator();
    private static IdOrderValidator idOrderValidator = new IdOrderValidator();

    private static ClientService serviceOrder = new ClientService(dataOrders, orderValidator);
    private static ChangePersonalDateService service = new ChangePersonalDateService(dataOrders, dateValidator);
    private static ChangePersonalSizeService sizeService = new ChangePersonalSizeService(dataOrders, sizeValidator);
    private static ChangeComponentService componentService1 = new ChangeComponentService(dataOrders, componentValidator);
    private static ShowOrderService orderService = new ShowOrderService(dataOrders, showOrderValidator);
    private static DeleteOrderService deleteOrderService = new DeleteOrderService(dataOrders, idOrderValidator);

    private static UIAction orderIUAction = new OrderUIAction(serviceOrder);
    private static UIAction dateUIAction = new ChangePersonalDateUIAction(service);
    private static UIAction sizeUIAction = new ChangePersonalSizeUIAction(sizeService);
    private static UIAction componentsUIAction = new ChangeComponentsUIAction(componentService1);
    private static UIAction showOrderUIAction = new ShowOrderUIAction(orderService);
    private static UIAction menuUIAction = new ShowMenuUIAction();
    private  static UIAction deleteOrder = new DeleteOrderUIAction(deleteOrderService);

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        while (true) {
            menuUIAction.execute();
            int choose = scan.nextInt();
            switch (choose) {
                case (1):
                    orderIUAction.execute();
                    break;
                case (2):
                    showOrderUIAction.execute();
                    break;
                case (3):
                    dateUIAction.execute();
                    break;
                case (4):
                    sizeUIAction.execute();
                    break;
                case (5):
                    componentsUIAction.execute();
                    break;
                case(6) :
                    deleteOrder.execute();
                case (7):
                    System.exit(0);
            }
        }
    }

}

