package lv.avangardteen;

import lv.avangardteen.UIAction.*;
import lv.avangardteen.core.service.*;
import lv.avangardteen.core.service.validate.*;
import lv.avangardteen.data.DataComponents;
import lv.avangardteen.data.DataOrders;
import lv.avangardteen.data.Database;

import java.util.Scanner;

public class OrderApplication {

    private static Database database = new DataOrders();
    private static DataComponents dataComponents = new DataComponents();
    private static ClientIdValidator idValidator = new ClientIdValidator(database);
    private static PersonalDateValidation personalDateValidation = new PersonalDateValidation();
    private static PersonalSizeValidator personalSizeValidator = new PersonalSizeValidator();
    private static ComponentValidator componentValidator = new ComponentValidator(dataComponents);
    private static ClientOrderValidator orderValidator = new ClientOrderValidator(personalDateValidation, personalSizeValidator, componentValidator);
    private static ChangePersonalDateValidator dateValidator = new ChangePersonalDateValidator(idValidator, personalDateValidation);
    private static ChangePersonalSizeValidator sizeValidator = new ChangePersonalSizeValidator(idValidator, personalSizeValidator);
    private static ChooseComponentValidator chooseComponentValidator = new ChooseComponentValidator(idValidator, componentValidator);
    private static ShowOrderValidator showOrderValidator = new ShowOrderValidator(idValidator);
    private static IdOrderValidator idOrderValidator = new IdOrderValidator(idValidator);

    private static ClientService serviceOrder = new ClientService(database, orderValidator);
    private static ChangePersonalDateService service = new ChangePersonalDateService(database, dateValidator);
    private static ChangePersonalSizeService sizeService = new ChangePersonalSizeService(database, sizeValidator);
    private static ChangeComponentService componentService1 = new ChangeComponentService(database, chooseComponentValidator);
    private static ShowOrderService orderService = new ShowOrderService(database, showOrderValidator);
    private static DeleteOrderService deleteOrderService = new DeleteOrderService(database, idOrderValidator);

    private static UIAction orderIUAction = new OrderUIAction(serviceOrder);
    private static UIAction dateUIAction = new ChangePersonalDateUIAction(service);
    private static UIAction sizeUIAction = new ChangePersonalSizeUIAction(sizeService);
    private static UIAction componentsUIAction = new ChangeComponentsUIAction(componentService1);
    private static UIAction showOrderUIAction = new ShowOrderUIAction(orderService);
    private static UIAction menuUIAction = new ShowMenuUIAction();
    private static UIAction deleteOrder = new DeleteOrderUIAction(deleteOrderService);

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
                case (6):
                    deleteOrder.execute();
                case (7):
                    System.exit(0);
            }
        }
    }

}

