package console_UI;

public class ExitUIAction implements UIAction{

    @Override
    public void execute() {
        System.out.println("All the best");
        System.exit(0);
    }

}
