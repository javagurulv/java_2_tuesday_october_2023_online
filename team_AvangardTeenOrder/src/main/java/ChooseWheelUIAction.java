import java.util.Scanner;

public class ChooseWheelUIAction implements UIAction{

    private ComponentList componentList;

    public ChooseWheelUIAction(ComponentList componentList) {
        this.componentList = componentList;
    }
    @Override
    public void execute(Wheelchair wheelchair) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите тип и размер передних колес коляски" + "\n Введите марку выбранных колес");
        System.out.println(componentList.allWheels());
        String wheelChoose = scanner.nextLine();
        wheelchair.addComponents(wheelChoose, componentList);
    }
}
