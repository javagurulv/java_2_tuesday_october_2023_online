import java.util.Map;

public class ShowAllComponentsUIAction implements UIAction {


    @Override
    public void execute(Wheelchair wheelchair) {

        for (Map.Entry<Category, Component> entry : wheelchair.getComponents().entrySet()) {
            System.out.println(entry);
        }

    }
}
