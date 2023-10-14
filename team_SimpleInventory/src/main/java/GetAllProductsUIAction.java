public class GetAllProductsUIAction implements UIAction {


    private Database database;


    public GetAllProductsUIAction(Database database){
        this.database = database;
    }
    @Override
    public void execute() {
            System.out.println("PRODUCT LIST");
            database.getAllProducts().forEach(System.out::println);
    }
}
