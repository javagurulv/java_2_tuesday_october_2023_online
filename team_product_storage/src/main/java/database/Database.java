package database;

import domain.Product;

import java.util.List;

public interface Database {
    void addProduct(Product product);

    void deleteProduct (Product product);

    List<Product> getAllProducts ();
    }


