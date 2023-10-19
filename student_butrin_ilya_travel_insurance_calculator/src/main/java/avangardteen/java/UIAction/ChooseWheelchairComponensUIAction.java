package avangardteen.java.UIAction;

import avangardteen.java.data.DataComponents;
import avangardteen.java.Wheelchair;
import avangardteen.java.service.ChooseWheelChairComponentsServis;

import java.util.Scanner;


public class ChooseWheelchairComponensUIAction implements UIAction {
    ChooseWheelChairComponentsServis servis;

    public ChooseWheelchairComponensUIAction(ChooseWheelChairComponentsServis servis) {
        this.servis = servis;
    }

    DataComponents data = new DataComponents();

    @Override
    public void execute() {
        addFrontWheels();
        addBreaks();
        addArmrest();
    }

    private void addFrontWheels() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите тип и размер передних колес коляски");
        for (int i = 0; i < data.allWheels().size(); i++) {
            System.out.println(i + 1 + ". " + data.allWheels().get(i).getInformation()
                    + ". Цена: " + data.allWheels().get(i).getPrice());
        }
        int choose = scanner.nextInt();
        servis.addWheels(choose);
    }

    private void addArmrest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("На последок выберем подлокотники");
        for (int i = 0; i < data.allArmest().size(); i++) {
            System.out.println(i + 1 + ". " + data.allArmest().get(i).getInformation()
                    + ". Цена: " + data.allArmest().get(i).getPrice());
        }
        int choose = scanner.nextInt();
        servis.addArmest(choose);
    }

    private void addBreaks() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Теперь определимся с тормозами" + "\n Введите марку выбранных тормозов");
        for (int i = 0; i < data.allBrakes().size(); i++) {
            System.out.println(i + 1 + ". " + data.allBrakes().get(i).getInformation()
                    + ". Цена: " + data.allBrakes().get(i).getPrice());
        }
        int choose = scanner.nextInt();
        servis.addBreaks(choose);
    }
}

