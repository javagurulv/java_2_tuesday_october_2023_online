package fitness_club.core.responses;

import fitness_club.core.responses.CoreError;

import java.util.List;

public class CoreResponse {
    private List<CoreError> errors;

    public CoreResponse() {
    }

    public CoreResponse(List<CoreError> errors) {
        this.errors = errors;
    }

    public List<CoreError> getErrors() {
        return errors;
    }
    public boolean hasErrors() { return errors != null && !errors.isEmpty(); }
}
