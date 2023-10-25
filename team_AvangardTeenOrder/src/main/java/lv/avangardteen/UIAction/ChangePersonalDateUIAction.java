package lv.avangardteen.UIAction;

import lv.avangardteen.core.request.ChangePersonalDateRequest;
import lv.avangardteen.core.service.ChangePersonalDateService;
import lv.avangardteen.data.DataOrders;

import java.util.Scanner;

public class ChangePersonalDateUIAction implements UIAction {
DataOrders dataOrders;
ChangePersonalDateService service;

    public ChangePersonalDateUIAction(ChangePersonalDateService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        System.out.println("Введите номер заказа");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите Имя и Фамилию");
        String nameSurname = scan.nextLine();
        System.out.println("Введите номер телефона");
        String phoneNumber = scan.nextLine();
        System.out.println("Введите свой адрес");
        String address = scan.nextLine();
       ChangePersonalDateRequest request = new ChangePersonalDateRequest(id, nameSurname, phoneNumber, address);
       service.execute(request);


    }
}
/*
System.out.println("Bведите персональный код ID");
        Scanner scanner = new Scanner(System.in);
        long id = scanner.nextLong();
        System.out.println("Ваше значение " + dataOrders.getClient(id).getNameSurname());
        System.out.println("Введите Имя и Фамилию");
        String nameSurname = scanner.nextLine();
        System.out.println("Ваше значение " + dataOrders.getClient(id).getPhoneNumber());
        System.out.println("Введите номер телефона");
        String phoneNumber = scanner.nextLine();
        System.out.println("Ваше значение " + dataOrders.getClient(id).getUserAddress());
        System.out.println("Введите свой адрес");
        String address = scanner.nextLine();
        ChangePersonalDateRequest request = new ChangePersonalDateRequest(id, nameSurname, phoneNumber, address);
        service.execute(request);*/
