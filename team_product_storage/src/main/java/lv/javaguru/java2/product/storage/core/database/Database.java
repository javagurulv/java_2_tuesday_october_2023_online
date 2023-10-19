package lv.javaguru.java2.product.storage.core.database;

import lv.javaguru.java2.product.storage.core.domain.Product;

import java.util.List;

public interface Database {
    void save(Product product);

    boolean deleteById(Long id);

    List<Product> getAllProducts ();
    }


