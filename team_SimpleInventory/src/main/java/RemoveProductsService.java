public class RemoveProductsService {
    private Database database;

    public RemoveProductsService (Database database){
        this.database = database;
    }
    public void execute(Long productId){
        database.remove(productId);
    }
}
