package lv.avangardteen.core.request;

public class ShowOrderRequest {
    long id;

    public ShowOrderRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
