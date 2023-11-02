package lv.avangardteen.core.request;

public class DeleteOrderRequest {
    Long id;


    public DeleteOrderRequest(Long id) {
        this.id = id;

    }

    public Long getId() {
        return id;
    }


}
