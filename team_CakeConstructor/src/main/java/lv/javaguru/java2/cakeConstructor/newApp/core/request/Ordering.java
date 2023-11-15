package lv.javaguru.java2.cakeConstructor.newApp.core.request;

public class Ordering {

    private String orderBy;
    private String orderDirection;

    public String getOrderBy() {
        return orderBy;
    }

    public String getOrderDirection() {
        return orderDirection;
    }

    public Ordering (String orderBy, String orderDirection){
        this.orderBy=orderBy;
        this.orderDirection=orderDirection;
    }
}
