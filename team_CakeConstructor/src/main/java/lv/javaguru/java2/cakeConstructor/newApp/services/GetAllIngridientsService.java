package lv.javaguru.java2.cakeConstructor.newApp.services;

import lv.javaguru.java2.cakeConstructor.newApp.database.DatabaseImpl;
import lv.javaguru.java2.cakeConstructor.newApp.database.Ingridient;

import java.util.List;

public class GetAllIngridientsService {

    private DatabaseImpl database;

    public GetAllIngridientsService (DatabaseImpl database){
        this.database=database;
    }

    public List<Ingridient> execute(){
        return database.getAllIngridients();
    }
}
