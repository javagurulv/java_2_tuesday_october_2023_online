package lv.avangardteen.core.request;

public class DeleteOrderRequest {
    Long id;


    public DeleteOrderRequest(Long id) {
        this.id = id;

    }

    public DeleteOrderRequest(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
