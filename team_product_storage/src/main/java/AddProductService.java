public class AddProductService {

    private Database database;

    public AddProductService(Database database) {
        this.database = database;
    }

    public void addProduct(String productName, Long productID) {
        Product product = new Product(productName, productID);
        database.addProduct(product);
    }


}
