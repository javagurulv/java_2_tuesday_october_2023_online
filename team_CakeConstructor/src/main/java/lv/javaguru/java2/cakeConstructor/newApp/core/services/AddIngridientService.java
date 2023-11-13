package lv.javaguru.java2.cakeConstructor.newApp.core.services;

import lv.javaguru.java2.cakeConstructor.newApp.core.database.DatabaseImpl;
import lv.javaguru.java2.cakeConstructor.newApp.core.database.Ingridient;
import lv.javaguru.java2.cakeConstructor.newApp.core.request.AddIngridientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.AddIngridientResponse;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;

import java.util.List;

public class AddIngridientService {

    private DatabaseImpl database;
    private AddIngridientValidation validation;

    public AddIngridientService(DatabaseImpl database, AddIngridientValidation validation){
        this.database=database;
        this.validation=validation;
    }

    public AddIngridientResponse execute(AddIngridientRequest request){
        List<CoreError> errors = validation.validate(request);
        if (!errors.isEmpty()) {
            return new AddIngridientResponse(errors);
        }

        Ingridient ingridient= new Ingridient(request.getTypeOfIngridient(), request.getTasteOfIngridient());
        database.save(ingridient);

        return new AddIngridientResponse(ingridient);
    }
}
