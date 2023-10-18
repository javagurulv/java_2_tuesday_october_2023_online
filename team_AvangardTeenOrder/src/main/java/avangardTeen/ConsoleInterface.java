package avangardTeen;

import avangardTeen.console_ui.*;

import avangardTeen.database.ComponentList;
import avangardTeen.domain.UserData;
import avangardTeen.domain.Wheelchair;

import avangardTeen.services.*;

import java.util.*;

public class
ConsoleInterface {
    private static ComponentList componentList = new ComponentList();
    private static UIAction chooseWheels = new ChooseWheelUIAction(componentList);
    private static UIAction chooseArmrest = new ChooseArmrestUIAction(componentList);
    private static UIAction chooseBreaks = new ChooseBreaksUIAction(componentList);
    private static UIAction changeComponent = new ChangeComponentUIAction(componentList);
    private static UIAction showAllComponents = new ShowAllComponentsUIAction();
    private static UIAction showAllPrice = new ShowAllPricesUIAction();


    public static void main(String[] args) throws InterruptedException {


        Scanner scan = new Scanner(System.in);
        Wheelchair wheelchair = new Wheelchair(0, 0, 0, 0, new HashMap<>());
        UserSizes size = new UserSizes(0, 0, 0, 0);
        UserData userData = new UserData("","","");

        AddPelwisWidthService addPelwisWidthService = new AddPelwisWidthService(size);
        AddThighLengthService addThighLengthService = new AddThighLengthService(size);
        AddBackLengthService addBackLengthService = new AddBackLengthService(size);
        AddShinLengthService addShinLengthService = new AddShinLengthService(size);
        CheckDataService checkDataService = new CheckDataService(size);
        AddNameSurnameService addNameSurnameService = new AddNameSurnameService(userData);
        AddPhoneNumberService addPhoneNumberService = new AddPhoneNumberService(userData);
        AddUserAddressService addUserAddressService = new AddUserAddressService(userData);
        ShowPersonalDateToCheckService showPersonalDateToCheckService = new ShowPersonalDateToCheckService(userData);


        AddPelwisWidthUIAction addPelwicWidthUIAction = new AddPelwisWidthUIAction(addPelwisWidthService);
        AddThighLengthUIAction addThighLengthUIAction = new AddThighLengthUIAction(addThighLengthService);
        AddBackLengthUIAction addBackLengthUIAction = new AddBackLengthUIAction(addBackLengthService);
        AddShinLengthUIAction addShinLengthUIAction = new AddShinLengthUIAction(addShinLengthService);
        CheckDataUIAction checkDataUIAction = new CheckDataUIAction(checkDataService);
        AddNameSurnameUIAction addNameSurnameUIAction = new AddNameSurnameUIAction(addNameSurnameService);
        AddPhoneNumberUIAction addPhoneNumberUIAction = new AddPhoneNumberUIAction(addPhoneNumberService);
        AddUserAddressUIAction addUserAddressUIAction = new AddUserAddressUIAction(addUserAddressService);
        ShowPersonalDateToCheckUIAction showPersonalDateToCheckUIAction = new ShowPersonalDateToCheckUIAction(showPersonalDateToCheckService);
        ProgramExitUIAction programExitUIAction = new ProgramExitUIAction();


        while (true) {
            showMenu();
            int choose = userSelection(scan);
            switch (choose) {
                case (1):
                //    pelwicWidth(scan, size);
                    addPelwicWidthUIAction.execute(addPelwisWidthService);
                 //   thighLength(scan, size);
                    addThighLengthUIAction.execute(addThighLengthService);
                  //  backLength(scan, size);
                    addBackLengthUIAction.execute(addBackLengthService);
                   // shinLength(scan, size);
                    addShinLengthUIAction.execute(addShinLengthService);
                  //  checkData(size);
                    checkDataUIAction.execute(checkDataService);
                    sayOk(scan, "Данные сохранены");
                    break;
                case (2):
                    selectParametrToChenge(size);
                    int chanch = userSelection(scan);
                    switch (chanch) {
                        case (1):
                            adjustpelwicWidth(scan, size);
                            break;
                        case (2):
                            adjustThighLength(scan, size);
                            break;
                        case (3):
                            adjustBackLength(scan, size);
                            break;
                        case (4):
                            adjustShinLength(scan, size);
                            break;
                    }
                    break;
                case (3):
                 //   checkData(size);
                    checkDataUIAction.execute(checkDataService);
                    sayOk(scan,"");
                    break;

                case (4):
                    System.out.println("А теперь давайте поговорим о самой коляске. " +
                            "\n Я буду на выбор давать Вам несколько вариантов основных элементов, из которых Вам надо будет выбрать один вариант. \n " +
                            "В каждом пункте будет указана цена, которая будет прибавляться к стоимости коляске. \n " +
                            "Если вместо цены стоит ноль, значит этот элемент входит в базовую стоимость и не увеличивает общую стоимость коляски.");
                    System.out.println();
                    chooseWheels.execute(wheelchair);
                    chooseBreaks.execute(wheelchair);
                    chooseArmrest.execute(wheelchair);
                    break;
                case (5):
                    changeComponent.execute(wheelchair);
                    break;
                case (6):
                    showAllComponents.execute(wheelchair);
                    sayOk(scan,"");
                    showAllPrice.execute(wheelchair);
                    break;
                case (7):
                    addNameSurnameUIAction.execute(addNameSurnameService);
                    addPhoneNumberUIAction.execute(addPhoneNumberService);
                    addUserAddressUIAction.execute(addUserAddressService);
                    showPersonalDateToCheckUIAction.execute(showPersonalDateToCheckService);
                    programExitUIAction.execute();


            }
        }
    }


    private static void adjustShinLength(Scanner scan, UserSizes size) {
        System.out.println("введите новое значение длины голени");
        int newShinLength = userSelection(scan);
        size.setShinLength(newShinLength);
        System.out.println("Новое значение сохранено");
    }

    private static void adjustBackLength(Scanner scan, UserSizes size) {
        System.out.println("введите новое значение длины спины до нижнего края лопатки");
        int newBackLength = userSelection(scan);
        size.setBackHeight(newBackLength);
        System.out.println("Новое значение сохранено");
    }

    private static void adjustThighLength(Scanner scan, UserSizes size) {
        System.out.println("введите новое значение длины бедра");
        int newThighLength = userSelection(scan);
        size.setThighLength(newThighLength);
        System.out.println("Новое значение сохранено");
    }

    private static void adjustpelwicWidth(Scanner scan, UserSizes size) {
        System.out.println("введите новое значение ширины таза");
        int newPelwicWidth = userSelection(scan);
        size.setPelvisWidth(newPelwicWidth);
        System.out.println("Новое значение сохранено");
    }

    private static void selectParametrToChenge(UserSizes size) {
        System.out.println("Какой из параметров хотите поменять?");
        System.out.println("1. ширина таза:  " + size.getPelvisWidth());
        System.out.println("2. длина бедра: " + size.getThighLength());
        System.out.println("3. длина спины до нижнего края лопатки: " + size.getBackHeight());
        System.out.println("4. длину голени: " + size.getShinLength());
    }

    private static void sayOk(Scanner scan, String message) {
        String ok = scan.next();
        if (ok.equals("ok")) System.out.println(message);
    }
/*
    private static void checkData(UserSizes size) {
        System.out.println("Ваши параметры: ");
        System.out.println("ширина таза:  " + size.getPelvisWidth());
        System.out.println("длина бедра: " + size.getThighLength());
        System.out.println("длина спины до нижнего края лопатки: " + size.getBackHeight());
        System.out.println("длину голени: " + size.getShinLength());
        System.out.println("Нажмите \"ок\", чтобы сохранить данные");
    }

    private static void shinLength(Scanner scan, UserSizes size) {
        System.out.println("введите длину голени пользователя");
        int shinLength = userSelection(scan);
        size.setShinLength(shinLength);
    }

    private static void backLength(Scanner scan, UserSizes size) {
        System.out.println("введите длину спины пользователя до нижнего края лопатки");
        int backLength = userSelection(scan);
        size.setBackHeight(backLength);
    }

    private static void thighLength(Scanner scan, UserSizes size) {
        System.out.println("введите длину бедра пользователя");
        int thighLength = userSelection(scan);
        size.setThighLength(thighLength);
    }

    private static void pelwicWidth(Scanner scan, UserSizes size) {
        System.out.println("введите ширину таза пользователя");
        int pelwicWidth = userSelection(scan);
        size.setPelvisWidth(pelwicWidth);
    } */

    private static int userSelection(Scanner scan) {
        int choose = scan.nextInt();
        return choose;
    }

    private static void showMenu() {
        System.out.println("Подбор коляски Avangard Teen");
        System.out.println("Выберите пункт из меню");
        System.out.println("1. Ввести антромоиетрические данные клиента (длинна бедра, ширина таза, длинна голени, высота спины до нижнего края лопатки)");
        System.out.println("2. Изменить антропометрические данные клиента");
        System.out.println("3. Показать введенные антропометрические данные");
        System.out.println("4. Провести детализацию коляски");
        System.out.println("5. Внести изменения в детализацию коляски");
        System.out.println("6. Просмотр детализации и подсчет стоимости коляски");
        System.out.println("7. Заполнить личные данные для связи и выйти");
    }
}
