import java.util.Scanner;

public class ChooseBreaksUIAction implements UIAction{


    private ComponentList componentList;

    public ChooseBreaksUIAction(ComponentList componentList) {

        this.componentList = componentList;
    }

    @Override
    public void execute(Wheelchair wheelchair) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Теперь определимся с тормозами" + "\n Введите марку выбранных тормозов");
        System.out.println(componentList.allBrakes());
        String breaksChoose = scanner.nextLine();
        wheelchair.addComponents(breaksChoose, componentList);
    }
}
