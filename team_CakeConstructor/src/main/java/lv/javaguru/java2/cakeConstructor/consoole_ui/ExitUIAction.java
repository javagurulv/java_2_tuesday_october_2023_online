package lv.javaguru.java2.cakeConstructor.consoole_ui;

public class ExitUIAction implements  UIAction {

    @Override
    public void execute() {
        System.out.println("Thank you for being with us!");
        System.exit(0);
    }
}
