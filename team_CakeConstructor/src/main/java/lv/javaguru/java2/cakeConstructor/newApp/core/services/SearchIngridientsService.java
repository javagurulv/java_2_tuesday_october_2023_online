package lv.javaguru.java2.cakeConstructor.newApp.core.services;

import lv.javaguru.java2.cakeConstructor.newApp.core.database.DatabaseImpl;
import lv.javaguru.java2.cakeConstructor.newApp.core.database.Ingridient;
import lv.javaguru.java2.cakeConstructor.newApp.core.request.SearchIngridientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.SearchIngridientResponse;

import java.util.List;

public class SearchIngridientsService {

    private DatabaseImpl database;
    private SearchIngridientRequestValidation validation;

    public SearchIngridientsService (DatabaseImpl database, SearchIngridientRequestValidation validation){
        this.database=database;
        this.validation=validation;
    }

    public SearchIngridientResponse execute(SearchIngridientRequest request) {
        List<CoreError> errors = validation.validation(request);
        if (!errors.isEmpty()) {
            return new SearchIngridientResponse(null, errors);
        }

        List<Ingridient> ingridients = null;
        if (request.isTypeProvided() && !request.isTasteProvided()) {
            ingridients = database.findByType(request.getTypeOfIngridient());
        }
        if (!request.isTypeProvided() && request.isTasteProvided()) {
            ingridients = database.findByTaste(request.getTasteOfIngridient());
        }
        if (request.isTypeProvided() && request.isTasteProvided()) {
            ingridients = database.findByTypeAndTaste(request.getTypeOfIngridient(), request.getTasteOfIngridient());
        }

        return new SearchIngridientResponse(ingridients, null);
    }

}
