package lv.javaguru.java2.product.storage.core.database;

import lv.javaguru.java2.product.storage.core.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    void save(Product product);

    Optional<Product> getById(Long id);

    boolean deleteById(Long id);

    List<Product> getAllProducts();

    List<Product> findByProductBrand(String productBrand);

    List<Product> findByProductModel(String productModel);

    List<Product> findByProductBrandAndProductModel(String productBrand, String productModel);
}



