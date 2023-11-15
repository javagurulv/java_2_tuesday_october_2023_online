package lv.javaguru.java2.cakeConstructor.newApp.core.services;

import lv.javaguru.java2.cakeConstructor.newApp.core.database.DatabaseImpl;
import lv.javaguru.java2.cakeConstructor.newApp.core.request.RemoveIngridientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.RemoveIngridientResponse;

public class RemoveIngridientService {

    private DatabaseImpl database;

    public RemoveIngridientService (DatabaseImpl database){
        this.database =database;
    }

    public RemoveIngridientResponse execute (RemoveIngridientRequest request){
        boolean isIngridientRemoved = database.deleteById(request.getIngridientId());
        return new RemoveIngridientResponse(isIngridientRemoved);
    }
}
