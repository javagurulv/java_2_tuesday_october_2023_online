package avangardteen.java.UIAction;

import avangardteen.java.Component;
import avangardteen.java.data.DataComponents;
import avangardteen.java.request.ChooseWheelchairComponensRequest;
import avangardteen.java.responce.ChooseWheelchairComponensResponce;
import avangardteen.java.service.ChooseWheelChairComponentsServis;

import java.util.List;
import java.util.Scanner;


public class ChooseWheelchairComponensUIAction implements UIAction {
    ChooseWheelChairComponentsServis servis;

    public ChooseWheelchairComponensUIAction(ChooseWheelChairComponentsServis servis) {
        this.servis = servis;
    }

    DataComponents armrestList = new DataComponents();

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        addFrontWheels();
        int choosefrontWheels = scanner.nextInt();
        addBreaks();
        int chooseBreaks = scanner.nextInt();
        addArmrest();
        int chooseArmrest = scanner.nextInt();
        ChooseWheelchairComponensRequest request = new ChooseWheelchairComponensRequest(chooseArmrest,choosefrontWheels,chooseBreaks);
        ChooseWheelchairComponensResponce responce = servis.addAllComponent(request);
    }

    private void addFrontWheels() {
        System.out.println("Выберите тип и размер передних колес коляски");
        List<Component> frontWheelList = servis.getAllFrontWheels();
        for (int i = 0; i <  frontWheelList.size(); i++) {
            System.out.println(i + 1 + ". " + frontWheelList.get(i).getInformation()
                    + ". Цена: " + frontWheelList.get(i).getPrice());
        }
    }

    private void addArmrest() {
        System.out.println("На последок выберем подлокотники");
        List<Component> armrestList = servis.getAllArmest();
        for (int i = 0; i < armrestList.size(); i++) {
            System.out.println(i + 1 + ". " + armrestList.get(i).getInformation()
                    + ". Цена: " + armrestList.get(i).getPrice());
        }
    }

    private void addBreaks() {
        List<Component> breaksList = servis.getAllBrakes();
        System.out.println("Теперь определимся с тормозами" + "\n Введите марку выбранных тормозов");
        for (int i = 0; i < breaksList.size(); i++) {
            System.out.println(i + 1 + ". " + breaksList.get(i).getInformation()
                    + ". Цена: " + breaksList.get(i).getPrice());
        }
    }
}

