package avangardteen.java2app.UIAction;

import avangardteen.java2app.Component;
import avangardteen.java2app.data.DataComponents;
import avangardteen.java2app.dependency_injection.DIComponent;
import avangardteen.java2app.dependency_injection.DIDependency;
import avangardteen.java2app.request.ChooseWheelchairComponensRequest;
import avangardteen.java2app.responce.ChooseWheelchairComponensResponce;
import avangardteen.java2app.service.ChooseWheelChairComponentsServis;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@DIComponent
public class ChooseWheelchairComponensUIAction implements UIAction {
  @DIDependency
  ChooseWheelChairComponentsServis servis;

    DataComponents armrestList = new DataComponents();

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        addFrontWheels();
        int choosefrontWheels = scanner.nextInt();
        addBreaks();
        int chooseBreaks = scanner.nextInt();
        addBackWheelsSize();
        int chooseBackWheelsize = scanner.nextInt();
        addBackWheels(chooseBackWheelsize);
        int chooseBackWheels = scanner.nextInt();
        addArmrest();
        int chooseArmrest = scanner.nextInt();
        ChooseWheelchairComponensRequest request = new ChooseWheelchairComponensRequest(chooseArmrest,choosefrontWheels,chooseBreaks,chooseBackWheels,chooseBackWheelsize);
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
    private void addBackWheels(int backWheelSize) {
        System.out.println("А какие заднии колеса Вам нужны?");
        List<Component> backWheelList = new ArrayList<>();
        switch (backWheelSize) {
            case (1):
               backWheelList = servis.getAllBackWheelsFor20Size();
                break;
            case (2):
                backWheelList = servis.getAllBackWheelsFor22Size();
                break;
            case (3):
                backWheelList = servis.getAllBackWheelsFor24Size();
                break;
        }
            for (int i = 0; i < backWheelList.size(); i++) {
                System.out.println(i + 1 + ". " + backWheelList.get(i).getInformation()
                        + ". Цена: " + backWheelList.get(i).getPrice());
            }

    }
    private void addBackWheelsSize() {
        System.out.println("Какого размера поставим заднии колеса? ");
        List<Component> backWheelListSize = servis.getAllBackWheelsSize();
        for (int i = 0; i <  backWheelListSize.size(); i++) {
            System.out.println(i + 1 + ". " + backWheelListSize.get(i).getInformation());
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

