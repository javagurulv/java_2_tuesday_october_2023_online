package lv.javaguru.java2.cakeConstructor.newApp.core.response;

public class CoreError {

    private String field;
    private String message;

    public CoreError(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }
}
