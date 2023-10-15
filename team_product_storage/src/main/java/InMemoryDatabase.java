import java.util.ArrayList;
import java.util.List;

public class InMemoryDatabase implements Database {

    List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);

    }
    public void deleteProduct(Product product) {
        products.remove(product);
    }

    public List<Product> getAllProducts() {
        return products;
    }

}
