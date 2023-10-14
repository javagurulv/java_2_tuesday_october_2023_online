import java.util.List;

public class GetAllProductsService {
    private Database database;
    public GetAllProductsService(Database database){

        this.database = database;
    }


    public List<Product> execute(){
        return database.getAllProducts();
    }
}
