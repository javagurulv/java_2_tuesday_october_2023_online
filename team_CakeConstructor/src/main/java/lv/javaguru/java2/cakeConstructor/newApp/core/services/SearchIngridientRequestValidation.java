package lv.javaguru.java2.cakeConstructor.newApp.core.services;

import lv.javaguru.java2.cakeConstructor.newApp.core.request.SearchIngridientRequest;
import lv.javaguru.java2.cakeConstructor.newApp.core.response.CoreError;

import java.util.ArrayList;
import java.util.List;

public class SearchIngridientRequestValidation {

    public List<CoreError> validation (SearchIngridientRequest request){
        List<CoreError> errors = new ArrayList<>();
        errors.addAll(validateSearchFields(request));
        return errors;
    }
    private List<CoreError> validateSearchFields(SearchIngridientRequest request) {
        List<CoreError> errors = new ArrayList<>();
        if (isEmpty(request.getTypeOfIngridient()) && isEmpty(request.getTasteOfIngridient())) {
            errors.add(new CoreError("type", "Must not be empty!"));
            errors.add(new CoreError("taste", "Must not be empty!"));
        }
        return errors;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }
}
