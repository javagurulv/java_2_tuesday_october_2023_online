package lv.javaguru.java2.lessoncode.book.app.console_ui;

import org.springframework.stereotype.Component;

@Component
public class ProgramExitUIAction implements UIAction {
    @Override
    public void execute() {
        System.out.println("Goodbye!");
        System.exit(0);
    }
}
