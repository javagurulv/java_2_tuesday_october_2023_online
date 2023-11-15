package avangardteen.java;
import avangardteen.java.UIAction.*;
import avangardteen.java.UIAction.UIAction;
import avangardteen.java.data.DataComponents;
import avangardteen.java.data.DataUsers;
import avangardteen.java.service.*;
import avangardteen.java.service.valigation.AddAntropologDateValigation;
import avangardteen.java.service.valigation.ChangeAntropologDateValigation;

import java.util.Scanner;
public class
App {
    private static ApplicationContext applicationContext = new ApplicationContext();
    public static void main(String[] args) {
        ShowDataSizeUIActive  showDataSize = applicationContext.getBean(ShowDataSizeUIActive.class);
        Scanner scan = new Scanner(System.in);
        while (true) {
            showMenu();
            int choose  = scan.nextInt();
            switch (choose) {
                case (1):
                    AddAnthropometricDataIUActiv  addAnthropometricDataIUActiv = applicationContext.getBean(AddAnthropometricDataIUActiv.class);
                    addAnthropometricDataIUActiv.execute();
                    break;
                case (2):
                    System.out.println("какой из параметров хотите поменять?");
                    showDataSize.execute();
                    ChangenAtropologDateUIAAction  changenAtropologDateUIAAction = applicationContext.getBean(ChangenAtropologDateUIAAction.class);
                    changenAtropologDateUIAAction.execute();
                    break;
                case (3):
                    showDataSize.execute();
                    break;
                case (4):
                    System.out.println("А теперь давайте поговорим о самой коляске. " +
                            "\n У Вас будет несколько вариантов основных элементов, из которых  надо будет выбрать один вариант. \n " +
                            "В каждом пункте будет указана цена, которая будет прибавляться к стоимости коляске. \n " +
                            "Если вместо цены стоит ноль, значит этот элемент входит в базовую стоимость и не увеличивает общую стоимость коляски.");
                    System.out.println();
                    ChooseWheelchairComponensUIAction chooseWheelchairComponens = applicationContext.getBean(ChooseWheelchairComponensUIAction.class);
                    chooseWheelchairComponens.execute();
                    break;
                case (5):
                    ChangeComponentUIAction changeComponent = applicationContext.getBean(ChangeComponentUIAction.class);
                    changeComponent.execute();
                    break;
                case (6):
                    ShowAllComponentsUIAction  showAllComponents = applicationContext.getBean(ShowAllComponentsUIAction.class);
                    showAllComponents.execute();
                    break;
                case (7):
                    ShowAllPricesUIAction showAllPrice = applicationContext.getBean(ShowAllPricesUIAction.class);
                    showAllPrice.execute();
                    break;
                case (8):
                    AddPersonalDateIUAction addPersonalDate = applicationContext.getBean(AddPersonalDateIUAction.class);
                    addPersonalDate.execute();
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
