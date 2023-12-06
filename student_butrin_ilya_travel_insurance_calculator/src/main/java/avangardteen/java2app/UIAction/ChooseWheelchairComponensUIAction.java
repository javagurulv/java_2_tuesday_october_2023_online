package avangardteen.java2app.UIAction;

import avangardteen.java2app.ComponentWheelchair;
import avangardteen.java2app.data.DataComponents;
import org.springframework.beans.factory.annotation.Autowired;
import avangardteen.java2app.request.ChooseWheelchairComponensRequest;
import avangardteen.java2app.responce.ChooseWheelchairComponensResponce;
import avangardteen.java2app.service.ChooseWheelChairComponentsServis;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class ChooseWheelchairComponensUIAction implements UIAction {
  @Autowired
  ChooseWheelChairComponentsServis servis;

    DataComponents armrestList = new DataComponents();

    @Override
    public void execute() {
        System.out.println("А теперь давайте поговорим о самой коляске. " +
                "\n У Вас будет несколько вариантов основных элементов, из которых  надо будет выбрать один вариант. \n " +
                "В каждом пункте будет указана цена, которая будет прибавляться к стоимости коляске. \n " +
                "Если вместо цены стоит ноль, значит этот элемент входит в базовую стоимость и не увеличивает общую стоимость коляски.");
        System.out.println();
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
        List<ComponentWheelchair> frontWheelList = servis.getAllFrontWheels();
        for (int i = 0; i <  frontWheelList.size(); i++) {
            System.out.println(i + 1 + ". " + frontWheelList.get(i).getInformation()
                    + ". Цена: " + frontWheelList.get(i).getPrice());
        }
    }
    private void addBackWheels(int backWheelSize) {
        System.out.println("А какие заднии колеса Вам нужны?");
        List<ComponentWheelchair> backWheelList = new ArrayList<>();
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
        List<ComponentWheelchair> backWheelListSize = servis.getAllBackWheelsSize();
        for (int i = 0; i <  backWheelListSize.size(); i++) {
            System.out.println(i + 1 + ". " + backWheelListSize.get(i).getInformation());
        }
    }


    private void addArmrest() {
        System.out.println("На последок выберем подлокотники");
        List<ComponentWheelchair> armrestList = servis.getAllArmest();
        for (int i = 0; i < armrestList.size(); i++) {
            System.out.println(i + 1 + ". " + armrestList.get(i).getInformation()
                    + ". Цена: " + armrestList.get(i).getPrice());
        }
    }

    private void addBreaks() {
        List<ComponentWheelchair> breaksList = servis.getAllBrakes();
        System.out.println("Теперь определимся с тормозами" + "\n Введите марку выбранных тормозов");
        for (int i = 0; i < breaksList.size(); i++) {
            System.out.println(i + 1 + ". " + breaksList.get(i).getInformation()
                    + ". Цена: " + breaksList.get(i).getPrice());
        }
    }
}

