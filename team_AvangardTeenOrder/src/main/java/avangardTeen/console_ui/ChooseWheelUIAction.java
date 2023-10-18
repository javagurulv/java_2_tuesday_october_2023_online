package avangardTeen.console_ui;

import avangardTeen.domain.Component;
import avangardTeen.database.ComponentList;
import avangardTeen.domain.Wheelchair;

import java.util.Scanner;

public class ChooseWheelUIAction implements UIAction {

    private ComponentList componentList;

    public ChooseWheelUIAction(ComponentList componentList) {
        this.componentList = componentList;
    }
    @Override
    public void execute(Wheelchair wheelchair) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите тип и размер передних колес коляски" + "\n Введите марку выбранных колес");
        for(Component component : componentList.allWheels()) {
            System.out.println(component);
        }
        String wheelChoose = scanner.nextLine();
        wheelchair.addComponents(wheelChoose, componentList);
    }
}
