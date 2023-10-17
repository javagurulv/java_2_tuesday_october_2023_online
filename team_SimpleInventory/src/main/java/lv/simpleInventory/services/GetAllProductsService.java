package lv.simpleInventory.services;

import lv.simpleInventory.Product;
import lv.simpleInventory.database.Database;

import java.util.List;

public class GetAllProductsService {
    private Database database;
    public GetAllProductsService(Database database){

        this.database = database;
    }


    public List<Product> execute(){
        return database.getAllProducts();
    }
}
