import java.util.ArrayList;
import java.util.List;

public class InMemoryDatabase implements Database {

    List<Product> products = new ArrayList<>();
    private Long productId = 1L;


    @Override
    public void add(Product product) {
        product.setId(productId);
        productId++;
        products.add(product);
    }
    @Override
    public void remove(Long productId) {
    products.stream()
            .filter(product -> product.getId().equals(productId))
            .findFirst()
            .ifPresent(product -> products.remove(product));
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }
}

