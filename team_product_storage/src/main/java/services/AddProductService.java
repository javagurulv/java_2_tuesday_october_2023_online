package services;

import database.Database;
import domain.Product;

public class AddProductService {

    private Database database;

    public AddProductService(Database database) {
        this.database = database;
    }

    public void execute(String productName, Long productID) {
        Product product = new Product(productName, productID);
        database.addProduct(product);
    }

}
