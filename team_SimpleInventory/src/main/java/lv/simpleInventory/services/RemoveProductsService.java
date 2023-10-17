package lv.simpleInventory.services;

import lv.simpleInventory.database.Database;

public class RemoveProductsService {
    private Database database;

    public RemoveProductsService (Database database){
        this.database = database;
    }
    public void execute(Long productId){
        database.remove(productId);
    }
}
