package lv.javaguru.java2.cakeConstructor.core.cake.services;

import lv.javaguru.java2.cakeConstructor.core.cake.request.SearchUserRequest;
import lv.javaguru.java2.cakeConstructor.core.cake.responses.CoreError;

import java.util.ArrayList;
import java.util.List;

public class SearchUserRequestValidation {

    public List<CoreError> validate(SearchUserRequest request) {
        List<CoreError> errors = new ArrayList<>();
        errors.addAll(validateSearchFields(request));
        return errors;
    }

    private List<CoreError> validateSearchFields(SearchUserRequest request) {
        List<CoreError> errors = new ArrayList<>();
        if (isEmpty(request.getLogin()) && isEmpty(request.getUserName())) {
            errors.add(new CoreError("Login", "Must not be empty!"));
            errors.add(new CoreError("UserName", "Must not be empty!"));
        }
        return errors;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

}

