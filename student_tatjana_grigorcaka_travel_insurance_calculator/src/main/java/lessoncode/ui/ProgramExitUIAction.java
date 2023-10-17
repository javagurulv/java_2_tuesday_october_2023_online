package lessoncode.ui;

public class ProgramExitUIAction implements UIAction {
    @Override
    public void execute() {
        System.out.println("Goodbye!");
        System.exit(0);
    }
}
