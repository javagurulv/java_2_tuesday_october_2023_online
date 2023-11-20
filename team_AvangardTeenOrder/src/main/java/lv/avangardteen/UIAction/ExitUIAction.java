package lv.avangardteen.UIAction;

import lv.avangardteen.dependency_injection.DIComponent;

@DIComponent
public class ExitUIAction implements UIAction{
    @Override
    public void execute() {
        System.out.println("Good by!");
        System.exit(0);
    }
}
