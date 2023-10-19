package lv.javaguru.java2.product.storage.ui;

public class ExitProgramUIAction implements UIAction{

    @Override
    public void execute() {
        System.out.println("Exit!");
        System.exit(0);
    }
}
