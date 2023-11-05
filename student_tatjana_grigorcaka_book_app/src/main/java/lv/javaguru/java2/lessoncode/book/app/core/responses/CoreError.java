package lv.javaguru.java2.lessoncode.book.app.core.responses;

public class CoreError {

    private String errorCode;
    private String errorMessage;

    public CoreError(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
