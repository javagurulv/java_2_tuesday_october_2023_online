package lv.javaguru.java2.product.storage.core.responses;

import java.util.List;

public class CoreResponse {

    private List<CoreError> errors;

    public CoreResponse(List<CoreError> errors) {
        this.errors = errors;
    }

    public CoreResponse() {
    }

    public List<CoreError> getErrors() {
        return errors;
    }

    public boolean hasErrors() {
        return errors != null && !errors.isEmpty();
    }
}
