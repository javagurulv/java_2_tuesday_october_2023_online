package lessoncode;

import java.util.List;

public abstract class CoreResponse {

    private List<BusinessError> errors;

    public CoreResponse(List<BusinessError> errors) {
        this.errors = errors;
    }

    public List<BusinessError> getErrors() {
        return errors;
    }
}
