package avangardteen.java2app.UIAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
@Component
public class ProgramMenu {
  private Map<Integer, UIAction> menuNumber;

    @Autowired   public ProgramMenu( List<UIAction> uiActions) {
        menuNumber = new HashMap<>();
        menuNumber.put(1,findUiaction(uiActions, AddAnthropometricDataIUActiv.class));
        menuNumber.put(2,findUiaction(uiActions, ChangenAtropologDateUIAAction.class));
        menuNumber.put(3, findUiaction(uiActions, ShowDataSizeUIActive.class));
        menuNumber.put(4, findUiaction(uiActions, ChooseWheelchairComponensUIAction.class));
        menuNumber.put(5, findUiaction(uiActions, ChangeComponentUIAction.class));
        menuNumber.put(6, findUiaction(uiActions, ShowAllComponentsUIAction.class));
        menuNumber.put(7, findUiaction(uiActions, ShowAllPricesUIAction.class));
        menuNumber.put(8, findUiaction(uiActions, AddPersonalDateIUAction.class));
    }
private UIAction findUiaction (List <UIAction> uiAction, Class uiActionClass){
    return  uiAction.stream().filter(p->p.getClass().equals(uiActionClass)).findFirst().get();

}

    public void executeSelectedMenuItem(int selectedMenu) {
        menuNumber.get(selectedMenu).execute();
    }
    public int selectNumber(){
        Scanner scanner = new Scanner(System.in);
        int choose = Integer.parseInt(scanner.nextLine());
        return choose;
    }
    public void showMenu() {
        System.out.println("Подбор коляски Avangard Teen");
        System.out.println("Выберите пункт из меню");
        System.out.println("1. Ввести антромоиетрические данные клиента (длинна бедра, ширина таза, длинна голени, высота спины до нижнего края лопатки)");
        System.out.println("2. Изменить антропометрические данные клиента");
        System.out.println("3. Показать введенные антропометрические данные");
        System.out.println("4. Провести детализацию коляски");
        System.out.println("5. Внести изменения в детализацию коляски");
        System.out.println("6. Просмотр полную детализации коляски");
        System.out.println("7. Расчет стоимости коляски");
        System.out.println("8. Заполнить личные данные для связи и выйти");
    }
}
