package lv.javaguru.travel.insurance.consoleUI;

public class ExitUIAction implements UIAction {
    @Override
    public void execute() {
        System.out.println("Good BYE");
        System.exit(0);
    }
}
