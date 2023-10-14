import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ChangeComponentUIAction implements UIAction{

    private ComponentList componentList;

    public ChangeComponentUIAction(ComponentList componentList) {
        this.componentList = componentList;
    }

    @Override
    public void execute(Wheelchair wheelchair) {
        List<Category> showCategory = new ArrayList<>();
        int number = 0;
        System.out.println("какой из параметров вы хотите изменить?");
        for (Map.Entry<Category, Component> component : wheelchair.getComponents().entrySet()) {
            number++;

            System.out.println(number + ". " +
                    component.getKey() + ": " +
                    component.getValue().getInformation() + ". Цена: " +
                    component.getValue().getPrice());
            showCategory.add(component.getValue().getCategory());
        }
        chooseNewComponent(showCategory, componentList, wheelchair);
    }

    private static void chooseNewComponent(List<Category> showCategory, ComponentList componentList, Wheelchair wheelchair) {
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        System.out.println("выберите новое значение параметра " + showCategory.get(value - 1));
        List<Component> newChoose = new ArrayList<>();
        for (int i = 0; i < componentList.getAllComponents().size(); i++) {
            if (showCategory.get(value - 1).equals(componentList.getAllComponents().get(i).getCategory())) {
                newChoose.add(componentList.getAllComponents().get(i));
            }
        }
        for (Component component : newChoose) {
            System.out.println(component);
        }
        System.out.println("Введите марку выбранного компонента ");
        Scanner scan = new Scanner(System.in);
        String choose = scan.nextLine();
        wheelchair.addComponents(choose, componentList);
    }
}
