package fitness_club.console_UI;

import fitness_club.dependency_injection.DIComponent;

@DIComponent
public class ExitUIAction implements UIAction {

    @Override
    public void execute() {
        System.out.println("Program finished");
        System.exit(0);
    }
}
