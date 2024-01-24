package lv.avangardteen.core.request;

public class GetClientRequest {
    private Long id;

    public GetClientRequest() { }

    public GetClientRequest(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
