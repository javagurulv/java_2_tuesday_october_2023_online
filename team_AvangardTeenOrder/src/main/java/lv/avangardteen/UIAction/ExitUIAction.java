package lv.avangardteen.UIAction;

import org.springframework.stereotype.Component;

@Component
public class ExitUIAction implements UIAction {
    @Override
    public void execute() {
        System.out.println("Good bye!");
        System.exit(0);
    }
}
