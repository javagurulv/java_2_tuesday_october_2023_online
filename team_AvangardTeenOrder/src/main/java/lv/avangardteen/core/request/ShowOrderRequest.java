package lv.avangardteen.core.request;

public class ShowOrderRequest {
    Long id;

    public ShowOrderRequest() {
    }

    public ShowOrderRequest(Long id) {
        this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
