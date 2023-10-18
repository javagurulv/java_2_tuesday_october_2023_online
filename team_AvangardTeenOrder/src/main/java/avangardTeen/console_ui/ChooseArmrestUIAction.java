package avangardTeen.console_ui;

import avangardTeen.domain.Component;
import avangardTeen.database.ComponentList;
import avangardTeen.domain.Wheelchair;

import java.util.Scanner;

public class ChooseArmrestUIAction implements UIAction {

    private ComponentList componentList;

    public ChooseArmrestUIAction(ComponentList componentList) {

        this.componentList = componentList;
    }

    @Override
    public void execute(Wheelchair wheelchair) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("На последок выберем подлокотники" + "\n Введите марку выбранного подлокотника");
        for (Component component : componentList.allArmrest()) {
            System.out.println(component);
        }
        String armrestChoose = scanner.nextLine();
        wheelchair.addComponents(armrestChoose, componentList);
    }
}
