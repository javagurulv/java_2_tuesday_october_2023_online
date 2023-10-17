package database;

import domain.Product;

import java.util.List;

public interface Database {
    void addProduct(Product product);

    void removeProduct (Product product);

    List<Product> getAllProducts ();
    }


