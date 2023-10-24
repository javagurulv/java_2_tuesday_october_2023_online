package lv.avangardteen.UIAction;

import lv.avangardteen.core.request.ChangePersonalSizeRequest;
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
        System.out.println("Введите персональный код ID и заполните антропометрические данные");
        Scanner scanner = new Scanner(System.in);
        long id = scanner.nextLong();
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
        service.execute(request);
    }
}
   /* public int pelvisWidth; //ширина таза
    public int thighLength; //длинна бедра
    public int backHeight; //высота спины
    public int shinLength; //длинна голени*/