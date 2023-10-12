import java.util.*;

public class
ConsoleInterface {
    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        ComponentList componentList = new ComponentList();
        Wheelchair wheelchair = new Wheelchair(0, 0, 0, 0, new HashMap<>());
        UserSizes size = new UserSizes(0, 0, 0, 0);
        UserData userData = new UserData("","","");
        while (true) {
            showMenu();
            int choose = userSelection(scan);
            switch (choose) {
                case (1):
                    pelwicWidth(scan, size);
                    thighLength(scan, size);
                    backLength(scan, size);
                    shinLength(scan, size);
                    checkData(size);
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
                   checkData(size);
                   sayOk(scan,"");
                    break;

                case (4):
                    System.out.println("А теперь давайте поговорим о самой коляске. " +
                            "\n Я буду на выбор давать Вам несколько вариантов основных элементов, из которых Вам надо будет выбрать один вариант. \n " +
                            "В каждом пункте будет указана цена, которая будет прибавляться к стоимости коляске. \n " +
                            "Если вместо цены стоит ноль, значит этот элемент входит в базовую стоимость и не увеличивает общую стоимость коляски.");
                    System.out.println();
                    chooseWheels(scan, componentList, wheelchair);
                    chooseBreaks(scan, componentList, wheelchair);
                    chooseArmrest(scan, componentList, wheelchair);
                    break;
                case (5):
                    List<Category> showCathegory = new ArrayList<>();
                    selectCategoryToChange(wheelchair, showCathegory);
                    int value = userSelection(scan);
                    List<Component> newChoose = new ArrayList<>();
                    chooseNewComponent(scan, componentList, wheelchair, showCathegory, value, newChoose);
                    break;
                case (6):
                    showAllComponents(wheelchair);
                    sayOk(scan,"");
                    ShowAllprices(wheelchair);
                    break;
                case (7):
                    addPersonalDate(userData);
                    showPersonalDateToCheck(userData);
                    System.exit(0);

            }
        }
    }

    private static void showPersonalDateToCheck(UserData userData) {
        System.out.println("проверьте введенные данные: ");
        System.out.println("Имя, Фамилия:  " + userData.getNameSurname());
        System.out.println("номер телефона: " + userData.getPhoneNumber());
        System.out.println("фактический адрес проживания: " + userData.getUserAddress());
        System.out.println("Gооd Bye");
    }

    private static void addPersonalDate(UserData userData) {
        Scanner scan2 = new Scanner(System.in);
        System.out.println("введите Имя, Фамилия");
        String nameSurname = scan2.nextLine();
        userData.setNameSurname(nameSurname);
        System.out.println("введите номер телефона");
        String phoneNumber = scan2.nextLine();
        userData.setPhoneNumber(phoneNumber);
        System.out.println("введите фактический адрес проживания");
        String userAddress = scan2.nextLine();
        userData.setUserAddress(userAddress);
    }

    private static void ShowAllprices(Wheelchair wheelchair) {
        int priceComponents = 0;
        for (Map.Entry<Category, Component> component : wheelchair.getComponents().entrySet()) {
            priceComponents += component.getValue().getPrice();
        }
        int price = wheelchair.getPriceWheelchair() + priceComponents;
        System.out.println("Общая стоимость: Кресло-коляска Aвангард Teen - " + wheelchair.getPriceWheelchair());
        for (Map.Entry<Category, Component> component : wheelchair.getComponents().entrySet()) {
            System.out.println(component.getKey() + " - " + component.getValue().getPrice());
        }
        System.out.println("Общая стоимость: " + price);
    }

    private static void showAllComponents(Wheelchair wheelchair) {
        for (Map.Entry<Category, Component> component : wheelchair.getComponents().entrySet()) {
            System.out.println((component.getKey() + ": " + component.getValue().getInformation()) + "  Цена: " + component.getValue().getPrice());
        }
        System.out.println("нажмите \"ок\", чтобы продолжить");
    }

    private static void chooseNewComponent(Scanner scan, ComponentList componentList, Wheelchair wheelchair, List<Category> showCathegory, int value, List<Component> newChoose) {
        System.out.println("выберите новое значение параметра " + showCathegory.get(value - 1));
        for (int i = 0; i < componentList.getAllComponents().size(); i++) {
            if (showCathegory.get(value - 1).equals(componentList.getAllComponents().get(i).getCategory())) {
                newChoose.add(componentList.getAllComponents().get(i));
            }
        }
        for (int i = 0; i < newChoose.size(); i++) {
            System.out.println(i + 1 + ". " + newChoose.get(i).getInformation() + "цена: " + newChoose.get(i).getPrice());
        }
        value = scan.nextInt();
        wheelchair.AddComponents(newChoose.get(value - 1).getCategory(), newChoose.get(value - 1));
    }

    private static void selectCategoryToChange(Wheelchair wheelchair, List<Category> showCathegory) {
        int number = 0;
        System.out.println("какой из параметров вы хотите изменить?");
        for (Map.Entry<Category, Component> component : wheelchair.getComponents().entrySet()) {
            number++;

            System.out.println(number + ". " +
                    component.getKey() + ": " +
                    component.getValue().getInformation() + ". Цена: " +
                    component.getValue().getPrice());
            showCathegory.add(component.getValue().getCategory());
        }
    }

    private static void chooseArmrest(Scanner scan, ComponentList componentList, Wheelchair wheelchair) {
        System.out.println("На последок выберем подлокотники");
        List<Component> armrest = componentList.allArmrest();
        for (int i = 0; i < armrest.size(); i++) {
            System.out.println(i + 1 + ". " + componentList.getArmrest().get(i).getInformation() + "     цена: " + componentList.getArmrest().get(i).getPrice());
        }
        int armrestChoose = userSelection(scan);
        wheelchair.AddComponents(componentList.getArmrest().get(armrestChoose - 1).getCategory(), componentList.getArmrest().get(armrestChoose - 1));
        armrest.clear();
    }

    private static void chooseBreaks(Scanner scan, ComponentList componentList, Wheelchair wheelchair) {
        System.out.println("Теперь определимся с тормозами");
        List<Component> breaks = componentList.allBrakes();
        for (int i = 0; i < breaks.size(); i++) {
            System.out.println(i + 1 + ". " + componentList.getBrake().get(i).getInformation() + "     цена: " + componentList.getBrake().get(i).getPrice());
        }
        int breaksChoose = userSelection(scan);
        wheelchair.AddComponents(componentList.getBrake().get(breaksChoose - 1).getCategory(), componentList.getBrake().get(breaksChoose - 1));
        breaks.clear();
    }

    private static void chooseWheels(Scanner scan, ComponentList componentList, Wheelchair wheelchair) {
        System.out.println("Начнем с передних колес. Выберете тип и размер передних колес коляски");
        List<Component> wheels = componentList.allWheels();
        for (int i = 0; i < wheels.size(); i++) {
            System.out.println(i + 1 + ". " + componentList.getWheels().get(i).getInformation() + "     цена: " + componentList.getWheels().get(i).getPrice());
        }
        int wheel = userSelection(scan);
        wheelchair.AddComponents(wheels.get(wheel - 1).getCategory(), wheels.get(wheel - 1));
        wheels.clear();
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
    }

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
