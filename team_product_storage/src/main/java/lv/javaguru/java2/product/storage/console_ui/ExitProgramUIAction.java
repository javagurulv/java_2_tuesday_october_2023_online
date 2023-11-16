package lv.javaguru.java2.product.storage.console_ui;

import lv.javaguru.java2.product.storage.dependency_injection.DIComponent;

@DIComponent
public class ExitProgramUIAction implements UIAction{

    @Override
    public void execute() {
        System.out.println("Exit!");
        System.exit(0);
    }
}
