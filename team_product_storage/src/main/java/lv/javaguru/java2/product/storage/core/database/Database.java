package lv.javaguru.java2.product.storage.core.database;

import lv.javaguru.java2.product.storage.core.domain.Product;

import java.util.List;
import java.util.stream.Collectors;

public interface Database {
    void save(Product product);

    boolean deleteById(Long id);

    List<Product> getAllProducts();

    List<Product> findByProductName(String title);


    List<Product> findByProductBrand(String productBrand);


    List<Product> findByProductModel(String productModel);

    List<Product> findByProductBrandAndProductModel(String productBrand, String productModel);
}



