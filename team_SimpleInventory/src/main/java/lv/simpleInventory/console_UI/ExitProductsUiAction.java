package lv.simpleInventory.console_UI;

public class ExitProductsUiAction implements UIAction {
    @Override
    public void execute() {
        System.out.println("See Ya!");
        System.exit(0);
    }
}
