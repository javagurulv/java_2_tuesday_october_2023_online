package console_UI;

public class ExitUIAction implements UIAction {

    @Override
    public void execute() {
        System.out.println("Program finished");
        System.exit(0);
    }
}
