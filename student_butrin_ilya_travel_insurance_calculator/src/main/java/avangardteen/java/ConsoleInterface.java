package avangardteen.java;


import avangardteen.java.UIAction.*;
import avangardteen.java.UIAction.UIAction;
import avangardteen.java.data.DataComponents;
import avangardteen.java.data.DataUsers;
import avangardteen.java.service.*;
import avangardteen.java.service.valigation.AddAntropologDateValigation;

import java.util.Scanner;
public class
ConsoleInterface {
    static Client client = new Client(new Wheelchair(),
                                new UserSizes());
    private static AddAntropologDateValigation addAntropologDateValigation = new AddAntropologDateValigation();
    private static DataUsers data = new DataUsers();
    private static DataComponents dataComponents = new DataComponents();
    private static AddUserDataServis addUserDataServis = new AddUserDataServis(client, data);
    private static ChooseWheelChairComponentsServis chooseWheelChairComponentsServis = new ChooseWheelChairComponentsServis(dataComponents,client);
    private static AddAtropologDateServis addAntropometricDataServis = new AddAtropologDateServis(client,addAntropologDateValigation);
    private static GetAntropometricDataServis getAntropometricDataServis = new GetAntropometricDataServis(client);
    private static ChangeComponentServise changeComponentServise = new ChangeComponentServise(dataComponents,client);
    private static UIAction changeComponent = new ChangeComponentUIAction(changeComponentServise);
    private static ShowAllComponentsServis showAllComponentsServis = new ShowAllComponentsServis(client);
    private static UIAction showAllComponents = new ShowAllComponentsUIAction(showAllComponentsServis);
    private static ShowAllPricesServise showAllPricesServise = new ShowAllPricesServise(client);
    private static UIAction showAllPrice = new ShowAllPricesUIAction(showAllPricesServise);
    private static UIAction chooseWheelchairComponens = new ChooseWheelchairComponensUIAction(chooseWheelChairComponentsServis);
    public static UIAction addPersonalData = new AddPersonalDateIUAction(addUserDataServis);
    public static UIAction showDataSize = new ShowDataSizeUIActive(getAntropometricDataServis);
    public static AddAnthropometricDataIUActiv addAnthropometricDataIUActiv = new AddAnthropometricDataIUActiv(addAntropometricDataServis);
    public static ChooseAntropometricDataServis changenAtropologDateServis = new ChooseAntropometricDataServis(client);
    public static ChangenAtropologDateUIAAction changenAtropologDateUIAAction = new ChangenAtropologDateUIAAction(addAntropometricDataServis);
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            showMenu();
            int choose  = scan.nextInt();
            switch (choose) {
                case (1):
                    addAnthropometricDataIUActiv.execute();
                    break;
                case (2):
                    System.out.println("какой из параметров хотите поменять?");
                    showDataSize.execute();
                    changenAtropologDateUIAAction.execute();
                    break;
                case (3):
                    showDataSize.execute();
                    break;
                case (4):
                    System.out.println("А теперь давайте поговорим о самой коляске. " +
                            "\n Я буду на выбор давать Вам несколько вариантов основных элементов, из которых Вам надо будет выбрать один вариант. \n " +
                            "В каждом пункте будет указана цена, которая будет прибавляться к стоимости коляске. \n " +
                            "Если вместо цены стоит ноль, значит этот элемент входит в базовую стоимость и не увеличивает общую стоимость коляски.");
                    System.out.println();
                    chooseWheelchairComponens.execute();
                    break;
                case (5):
                    changeComponent.execute();
                    break;
                case (6):
                    showAllComponents.execute();
                    break;
                case (7):
                    showAllPrice.execute();
                    break;
                case (8):
                    addPersonalData.execute();
                    System.exit(0);
            }
        }
    }
    private static void showMenu() {
        System.out.println("Подбор коляски Avangard Teen");
        System.out.println("Выберите пункт из меню");
        System.out.println("1. Ввести антромоиетрические данные клиента (длинна бедра, ширина таза, длинна голени, высота спины до нижнего края лопатки)");
        System.out.println("2. Изменить антропометрические данные клиента");
        System.out.println("3. Показать введенные антропометрические данные");
        System.out.println("4. Провести детализацию коляски");
        System.out.println("5. Внести изменения в детализацию коляски");
        System.out.println("6. Просмотр полную детализации коляски");
        System.out.println("7. Расчет стоимости коляски");
        System.out.println("8. Заполнить личные данные для связи и выйти");
    }
}
