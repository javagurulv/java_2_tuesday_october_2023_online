package lv.simpleInventory.database;

import lv.simpleInventory.Product;

import java.util.List;

public interface Database {

    void add(Product product);

    void remove(Long productId);

    List<Product> getAllProducts();
}
