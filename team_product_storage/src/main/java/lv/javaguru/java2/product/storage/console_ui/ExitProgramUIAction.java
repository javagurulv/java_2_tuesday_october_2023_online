package lv.javaguru.java2.product.storage.console_ui;

public class ExitProgramUIAction implements UIAction{

    @Override
    public void execute() {
        System.out.println("Exit!");
        System.exit(0);
    }
}
