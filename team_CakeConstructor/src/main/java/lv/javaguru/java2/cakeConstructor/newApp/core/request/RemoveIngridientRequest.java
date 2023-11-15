package lv.javaguru.java2.cakeConstructor.newApp.core.request;

public class RemoveIngridientRequest {

    private Long ingridientId;

    public Long getIngridientId() {
        return ingridientId;
    }

    public RemoveIngridientRequest(Long ingridientId){
        this.ingridientId=ingridientId;
    }
}
