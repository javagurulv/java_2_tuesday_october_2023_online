package lv.javaguru.java2.product.storage.core.database;

import lv.javaguru.java2.product.storage.core.domain.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryDatabase implements Database {
    private Long nextId = 1L;
    List<Product> products = new ArrayList<>();

    @Override
    public void save(Product product) {
        product.setId(nextId);
        nextId++;
        products.add(product);
    }
    @Override
    public boolean deleteById(Long id) {
        boolean isProductDeleted = false;
        Optional<Product> productToDeleteOpt = products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst();
        if (productToDeleteOpt.isPresent()) {
            Product productToRemove = productToDeleteOpt.get();
            isProductDeleted = products.remove(productToRemove);
        }
        return isProductDeleted;
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

}
