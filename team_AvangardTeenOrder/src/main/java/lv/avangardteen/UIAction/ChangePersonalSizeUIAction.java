package lv.avangardteen.UIAction;

import lv.avangardteen.core.request.ChangePersonalSizeRequest;
import lv.avangardteen.core.responce.ChangePersonalSizeResponse;
import lv.avangardteen.core.service.ChangePersonalSizeService;
import lv.avangardteen.data.DataOrders;

import java.util.Scanner;

public class ChangePersonalSizeUIAction implements UIAction {
    DataOrders dataOrders;
    ChangePersonalSizeService service;

    public ChangePersonalSizeUIAction(ChangePersonalSizeService service) {
        this.service = service;
    }

    @Override
    public void execute() {
        System.out.println("Введите номер заказа");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите новое значение ширины таза");
        int pelvisWidth = scan.nextInt();

        System.out.println("Введите новое значение длины бедра");
        int thighLength = scan.nextInt();

        System.out.println("Введите новое значение высоты спины");
        int backHeight = scan.nextInt();

        System.out.println("Введите новое значение длины голени");
        int shinLength = scanner.nextInt();
        ChangePersonalSizeRequest request = new ChangePersonalSizeRequest(id, pelvisWidth, thighLength,
                backHeight, shinLength);
        ChangePersonalSizeResponse response = service.execute(request);
        if (response.hasErrors()) {
            response.getErrors().forEach(coreError ->
                    System.out.println(("ErrorInputs: " + coreError.getField() + " " + coreError.getMessage())));
            System.out.println("Ваш выбор не сохранен");
        } else {
            System.out.println("Ваши данные сохранены");
        }
    }
}
