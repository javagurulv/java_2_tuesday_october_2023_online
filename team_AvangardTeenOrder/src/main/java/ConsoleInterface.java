import java.util.*;
import java.util.concurrent.TimeUnit;

public class
ConsoleInterface {

    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        ComponentList componentList = new ComponentList();
        Wheelchair wheelchair = new Wheelchair(0, 0, 0, 0, new HashMap<>());
        UserSizes size = new UserSizes(0, 0, 0, 0);
        int choose = 0;
        while (choose != 7) {
            System.out.println("Подбор коляски Avangard Teen");
            System.out.println("Выберете пункт из меню");
            System.out.println("1. Ввести антромоиетрические данные клиента (длинна бедра, ширина таза, длинна голени, высота спины до нижнего края лопатки)");
            System.out.println("2. Изменить антропометрические данные клиента");
            System.out.println("3. Показать введенные антропометрические данные");
            System.out.println("4. Провести детализацию коляски");
            System.out.println("5. Внести изменения в детализацию коляски");
            System.out.println("6. Просмотр детализации и подсчет стоимости коляски");
            System.out.println("7. Заполнить личные данные для связи и выйти");
            choose = scan.nextInt();

            switch (choose) {
                case (1):
                    System.out.println("введите ширину таза пользователя");
                    int pelwicWidth = scan.nextInt();
                    size.setPelvisWidth(pelwicWidth);
                    System.out.println("введите длинну бедра пользователя");
                    int thighLength = scan.nextInt();
                    size.setThighLength(thighLength);
                    System.out.println("введите длинну спины пользователя до нижнего края лопатки");
                    int backLength = scan.nextInt();
                    size.setBackHeight(backLength);
                    System.out.println("введите длинну голени пользователя");
                    int shinLength = scan.nextInt();
                    size.setShinLength(shinLength);
                    System.out.println("проверте введенные данные: ");
                    System.out.println("ширина таза:  " + size.getPelvisWidth());
                    System.out.println("длинна бедра: " + size.getThighLength());
                    System.out.println("длинна спины до нижнего края лопатки: " + size.getBackHeight());
                    System.out.println("длинну голени: " + size.getShinLength());
                    // создаем класс антропометрические данные и вставляем туда конструктор
                    System.out.println("Нажмите \"ок\", чтобы сохранить данные");
                    String ok = scan.next();
                    if (ok.equals("ok")) System.out.println("Данные сохранены");
                    Thread.sleep(2000);
                    break;
                case (2):
                    System.out.println("Какой из параметров хотите поменять?");
                    System.out.println("1. ширина таза:  " + size.getPelvisWidth());
                    System.out.println("2. длинна бедра: " + size.getThighLength());
                    System.out.println("3. длинна спины до нижнего края лопатки: " + size.getBackHeight());
                    System.out.println("4. длинну голени: " + size.getShinLength());

                    int chanch = scan.nextInt();
                    switch (chanch) {
                        case (1):
                            System.out.println("введите новое значение ширины таза");
                            int newPelwicWidth = scan.nextInt();
                            size.setPelvisWidth(newPelwicWidth);
                            System.out.println("Новое значение сохранено");
                            Thread.sleep(2000);
                            break;
                        case (2):
                            System.out.println("введите новое значение длинны бедра");
                            int newThighLength = scan.nextInt();
                            size.setThighLength(newThighLength);
                            System.out.println("Новое значение сохранено");
                            Thread.sleep(2000);
                            //сет в антропологии
                            break;
                        case (3):
                            System.out.println("введите новое значение длинна спины до нижнего края лопатки");
                            int newBackLength = scan.nextInt();
                            size.setBackHeight(newBackLength);
                            System.out.println("Новое значение сохранено");
                            Thread.sleep(2000);
                            break;
                        case (4):
                            System.out.println("введите новое значение длинны голени");
                            int newShinLength = scan.nextInt();
                            size.setShinLength(newShinLength);
                            System.out.println("Новое значение сохранено");
                            Thread.sleep(2000);
                            break;
                    }
                    break;
                case (3):
                    System.out.println("ширина таза:  " + size.getPelvisWidth());
                    System.out.println("длинна бедра: " + size.getThighLength());
                    System.out.println("длинна спины до нижнего края лопатки: " + size.getBackHeight());
                    System.out.println("длинна голени: " + size.getShinLength());
                    System.out.println("Нажмите \"ок\", чтобы продолжить");
                    String okey = scan.next();
                    break;

                case (4):
                    System.out.println("А теперь давайте поговорим о самой коляске. " +
                            "\n Я буду на выбор давать Вам несколько вариантов основных элементов, из которых Вам надо будет выбрать один вариант. \n " +
                            "В каждом пункте будет указана цена, которая будет прибавляться к стоимости коляске. \n " +
                            "Если вместо цены стоит ноль, значит этот элемент входит в базовую стоимость и не увеличивает общую стоимость коляски.");
                    System.out.println();
                    System.out.println("Начнем с передних колес. Выберете тип и размер передних колес коляски");
                    List<Component> wheels = componentList.allWheels();
                    for (int i = 0; i < wheels.size(); i++) {
                        System.out.println(i + 1 + ". " + componentList.getWheels().get(i).getInformation() + "     цена: " + componentList.getWheels().get(i).getPrice());
                    }
                    int wheel = scan.nextInt();
                    wheelchair.AddComponents(wheels.get(wheel - 1).getCategory(), wheels.get(wheel - 1));
                    wheels.clear();
                    System.out.println("Теперь определимся с тормозами");
                    List<Component> breaks = componentList.allBrakes();
                    for (int i = 0; i < breaks.size(); i++) {
                        System.out.println(i + 1 + ". " + componentList.getBrake().get(i).getInformation() + "     цена: " + componentList.getBrake().get(i).getPrice());
                    }
                    int breaksChoose = scan.nextInt();
                    wheelchair.AddComponents(componentList.getBrake().get(breaksChoose - 1).getCategory(), componentList.getBrake().get(breaksChoose - 1));
                    breaks.clear();
                    System.out.println("На последок выберем подлокотники");
                    List<Component> armrest = componentList.allArmrest();
                    for (int i = 0; i < armrest.size(); i++) {
                        System.out.println(i + 1 + ". " + componentList.getArmrest().get(i).getInformation() + "     цена: " + componentList.getArmrest().get(i).getPrice());
                    }
                    int armrestChoose = scan.nextInt();
                    wheelchair.AddComponents(componentList.getArmrest().get(armrestChoose - 1).getCategory(), componentList.getArmrest().get(armrestChoose - 1));
                    armrest.clear();
                    break;
                case (5):
                    System.out.println("какой из параметров вы хотите изменить?");
                    int number = 0;
                    List<Category> showCathegory = new ArrayList<>();
                    for (Map.Entry<Category, Component> component : wheelchair.getComponents().entrySet()) {
                        number++;

                        System.out.println(number + ". " +
                                component.getKey() + ": " +
                                component.getValue().getInformation() + ". Цена: " +
                                component.getValue().getPrice());
                        showCathegory.add(component.getValue().getCategory());
                    }
                    int value = scan.nextInt();
                    System.out.println("выберете новое значение параметра " + showCathegory.get(value - 1));
                    List<Component> newChoose = new ArrayList<>();
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
                    break;
                case (6):
                    for (Map.Entry<Category, Component> component : wheelchair.getComponents().entrySet()) {
                        System.out.println((component.getKey() + ": " + component.getValue().getInformation()) + "  Цена: " + component.getValue().getPrice());
                    }
                    System.out.println("нажмите \"ок\", чтобы продолжить");
                    okey = scan.next();
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
        }
    }
}
