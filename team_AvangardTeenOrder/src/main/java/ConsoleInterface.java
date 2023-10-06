import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ConsoleInterface {

    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        UserSizes size = new UserSizes(0,0,0,0);
        int choose = 0;
        while (choose != 7) {
            System.out.println("Подбор коляски Avangard Teen");
            System.out.println("Выберете пункт из меню");
            System.out.println("1. Ввести антромоиетрические данные клинта (длинна бедра, ширина таза, длинна голени, высота спины до нижнего края лопатки)");
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
                    System.out.println("3. длинна спины до нижнего края лопатки: " +size.getBackHeight());
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
                            //сет в антропологии
                            break;
                        case (4):
                            System.out.println("введите новое значение длинны голени");
                            int newShinLength = scan.nextInt();
                            size.setShinLength(newShinLength);
                            System.out.println("Новое значение сохранено");
                            Thread.sleep(2000);
                            //сет в антропологии
                            break;
                    }
                case (3):
                    System.out.println("ширина таза:  " + size.getPelvisWidth());
                    System.out.println("длинна бедра: " + size.getThighLength());
                    System.out.println("длинна спины до нижнего края лопатки: " +size.getBackHeight());
                    System.out.println("длинна голени: " + size.getShinLength());
                    System.out.println("Нажмите \"ок\", чтобы продолжить");
                    String okey = scan.next();
                    break;

                case (4):
                    System.out.println("А теперь давайте поговорим о самой коляске. " +
                            "\n Я буду на выбор давать Вам несколько вариантов основных элементов, из которых Вам надо будет выбрать один вариант. \n " +
                            "В каждм пункте будет указана цена, которая будет прибавляться к стоимости коляске. \n " +
                            "Если вместо цены стоит прочерк, значит этот элемент входит в базовую стоимость и не увеличивает общую стоимость коляски.");
                            System.out.println("1) колеса 3 дюйма");
                            System.out.println("2) колеса 4 дюйма");
                            System.out.println("3) колеса 5 дюйма");
                            System.out.println("4) колеса 6 дюйма");
                            int frontWheel = scan.nextInt();


            }
        }


    }
}



