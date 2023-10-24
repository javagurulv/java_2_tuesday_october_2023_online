package lv.avangardteen.UIAction;

import lv.avangardteen.core.service.ShowAllComponentsService;

import java.util.Scanner;

public class ShowAllComponentsUIAction implements UIAction {
ShowAllComponentsService service;

    public ShowAllComponentsUIAction(ShowAllComponentsService service) {
        this.service = service;
    }

    @Override
    public void execute() {
       service.execute();
        System.out.println("Изменить, введите 3");
        Scanner scanner = new Scanner(System.in);
        int choose = scanner.nextInt();
    }
}
