package lv.javaguru.java2.lessoncode.book.app.console_ui;

import lv.javaguru.java2.lessoncode.book.app.dependency_injection.DIComponent;

@DIComponent
public class ProgramExitUIAction implements UIAction {
    @Override
    public void execute() {
        System.out.println("Goodbye!");
        System.exit(0);
    }
}
