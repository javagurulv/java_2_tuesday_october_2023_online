package lv.javaguru.java2.lessoncode.book.app.core.responses;


import java.util.List;

abstract class CoreResponse {

    private List<CoreError> errors;

    public CoreResponse() {
    }

    public CoreResponse(List<CoreError> errors) {
        this.errors = errors;
    }

    public List<CoreError> getErrors() {
        return errors;
    }

    public boolean containsErrors() {
        return this.errors != null && !this.errors.isEmpty();
    }

}
