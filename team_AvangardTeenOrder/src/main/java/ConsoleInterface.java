import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class ConsoleInterface {

        public static void main(String[] args) throws InterruptedException {
            Scanner scan = new Scanner(System.in);
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
                        System.out.println("введите длинну бедра пользователя");
                        int hipLength = scan.nextInt();
                        System.out.println("введите длинну спины пользователя до нижнего края лопатки");
                        int backLength = scan.nextInt();
                        System.out.println("введите длинну голени пользователя");
                        int shinLength = scan.nextInt();
                        System.out.println("проверте введенные данные: ");
                        System.out.println("ширина таза:  " + pelwicWidth);
                        System.out.println("длинна бедра: " + hipLength);
                        System.out.println("длинна спины до нижнего края лопатки: " + backLength);
                        System.out.println("длинну голени: " + shinLength);
                        // создаем класс антропометрические данные и вставляем туда конструктор
                        System.out.println("Ваши данные сохранены. Нажмите \"ок\", чтобы продолжить");
                        String ok = scan.next();
                        if (ok.equals("ok")) System.out.println("Данные сохранены");
                        Thread.sleep(2000);
                        break;
                    case (2):
                        System.out.println("Какой из параметров хотите поменять?");
                        System.out.println("1. ширина таза:  "); // + геттер из класса антропометрические данные);
                        System.out.println("2. длинна бедра: "); // + геттер из класса антропометрические данные);
                        System.out.println("3. длинна спины до нижнего края лопатки: ");// + геттер из класса антропометрические данные);
                        System.out.println("4. длинну голени: "); // + геттер из класса антропометрические данные);
                        int chanch = scan.nextInt();
                            switch(chanch) {
                                case (1):
                                    System.out.println("введите новое значение ширины таза");
                                    int newPelwicWidth = scan.nextInt();
                                    System.out.println("Новое значение сохранено");
                                    Thread.sleep(2000);
                                    //сет в антропологии
                                    break;
                                case (2):
                                    System.out.println("введите новое значение длинны бедра");
                                    int newHipLength = scan.nextInt();
                                    System.out.println("Новое значение сохранено");
                                    Thread.sleep(2000);
                                    //сет в антропологии
                                    break;
                                case (3):
                                    System.out.println("введите новое значение длинна спины до нижнего края лопатки");
                                    int newBackLength = scan.nextInt();
                                    System.out.println("Новое значение сохранено");
                                    Thread.sleep(2000);
                                    //сет в антропологии
                                    break;
                                case (4):
                                    System.out.println("введите новое значение длинны голени");
                                    int newShinLength = scan.nextInt();
                                    System.out.println("Новое значение сохранено");
                                    Thread.sleep(2000);
                                    //сет в антропологии
                                    break;
                            }



                    }


                }
            }


        }



