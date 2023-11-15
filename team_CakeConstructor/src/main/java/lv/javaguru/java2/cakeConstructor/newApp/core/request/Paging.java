package lv.javaguru.java2.cakeConstructor.newApp.core.request;

public class Paging {

    private Integer pageNumber;

    private Integer pageSize;

    public Paging(Integer pageNumber, Integer pageSize) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }
}
