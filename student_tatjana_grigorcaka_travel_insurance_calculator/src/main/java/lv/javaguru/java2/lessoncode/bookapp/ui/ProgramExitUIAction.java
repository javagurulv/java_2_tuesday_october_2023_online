package lv.javaguru.java2.lessoncode.bookapp.ui;

public class ProgramExitUIAction implements UIAction {
    @Override
    public void execute() {
        System.out.println("Goodbye!");
        System.exit(0);
    }
}
