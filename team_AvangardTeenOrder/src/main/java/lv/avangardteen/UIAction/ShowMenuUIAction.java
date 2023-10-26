package lv.avangardteen.UIAction;

public class ShowMenuUIAction implements UIAction{

    @Override
    public void execute() {
        System.out.println("Заказ на инвалидное кресло Avangard Teen");
        System.out.println("Выберите пункт из меню");
        System.out.println("1. Оформить бланк заказа");
        System.out.println("2. Просмотреть бланк заказа");
        System.out.println("3. Внести изменения в личные данные");
        System.out.println("4. Внести изменения в антропометрические данные");
        System.out.println("5. Внести изменения в выборе компонентов");
        System.out.println("6. Удалить заказ");
        System.out.println("7. Сохранить заказ и выйти");
    }
}
