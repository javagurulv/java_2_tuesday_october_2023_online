package services;

import database.Database;
import domain.Product;

public class RemoveProductService {

    private Database database;

    public RemoveProductService(Database database) {
        this.database = database;
    }

    public void execute(String productName, Long productID) {
        Product product = new Product(productName, productID);
        database.removeProduct(product);
    }


}
