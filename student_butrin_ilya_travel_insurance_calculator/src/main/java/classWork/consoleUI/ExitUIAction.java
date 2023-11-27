package classWork.consoleUI;


import org.springframework.stereotype.Component;

@Component
public class ExitUIAction implements UIAction {
    @Override
    public void execute() {
        System.out.println("Good BYE");
        System.exit(0);
    }
}
