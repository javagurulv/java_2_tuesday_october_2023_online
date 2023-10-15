public class DeleteProductService {

    private Database database;

    public DeleteProductService(Database database) {
        this.database = database;
    }

    public void deleteProduct(String productName, Long productID) {
        Product product = new Product(productName, productID);
        database.deleteProduct(product);
    }


}
