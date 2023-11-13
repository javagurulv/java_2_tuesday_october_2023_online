package lv.javaguru.java2.cakeConstructor.newApp.services;

import lv.javaguru.java2.cakeConstructor.newApp.database.DatabaseImpl;

public class RemoveIngridientService {

    private DatabaseImpl database;

    public RemoveIngridientService (DatabaseImpl database){
        this.database =database;
    }

    public void execute (Long ingridientId){
        database.deleteById(ingridientId);
    }
}
