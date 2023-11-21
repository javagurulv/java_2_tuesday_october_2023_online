package classWork.consoleUI;

import classWork.dependency_injection.DIComponent;

@DIComponent
public class ExitUIAction implements UIAction {
    @Override
    public void execute() {
        System.out.println("Good BYE");
        System.exit(0);
    }
}
