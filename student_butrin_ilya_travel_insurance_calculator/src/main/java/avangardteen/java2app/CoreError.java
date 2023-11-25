package avangardteen.java2app;

public class CoreError {
    String location;
    String message;

    public String getLocation() {
        return location;
    }

    public String getMessage() {
        return message;
    }

    public CoreError(String location, String message) {
        this.location = location;
        this.message = message;
    }
}
