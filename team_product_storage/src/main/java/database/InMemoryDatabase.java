package database;

import domain.Product;

import java.util.ArrayList;
import java.util.List;

public class InMemoryDatabase implements Database {
    private Long nextId = 1L;

    List<Product> products = new ArrayList<>();
    @Override
    public void addProduct(Product product) {
        products.add(product);
    }
    @Override
    public void removeProduct(Product product) {
        products.remove(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

}
