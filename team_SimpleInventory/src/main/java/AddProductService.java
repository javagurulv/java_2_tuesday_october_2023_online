public class AddProductService {



private Database database;


public AddProductService(Database database) {
    this.database = database;
}

    public void execute(String productName, int productCount,double productPrice){
            Product product = new Product(productName,productCount,productPrice);
            database.add(product);
    }
}
