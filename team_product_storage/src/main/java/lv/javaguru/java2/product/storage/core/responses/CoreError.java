package lv.javaguru.java2.product.storage.core.responses;

public class CoreError {

    private String errorCode;
    private String message;

    public CoreError(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }
}
