package lv.javaguru.java2.cakeConstructor.newApp.services;

import lv.javaguru.java2.cakeConstructor.newApp.database.DatabaseImpl;
import lv.javaguru.java2.cakeConstructor.newApp.database.Ingridient;

public class AddIngridientService {

    private DatabaseImpl database;

    public AddIngridientService(DatabaseImpl database){
        this.database=database;
    }

    public void execute(String typeOfIngridient, String taste){
        Ingridient ingridient = new Ingridient(typeOfIngridient,taste);
        database.save(ingridient);
    }
}
