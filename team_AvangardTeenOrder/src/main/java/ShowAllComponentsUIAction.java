public class ShowAllComponentsUIAction implements UIAction {


    @Override
    public void execute(Wheelchair wheelchair) {

        System.out.println(wheelchair.getComponents());

    }
}
