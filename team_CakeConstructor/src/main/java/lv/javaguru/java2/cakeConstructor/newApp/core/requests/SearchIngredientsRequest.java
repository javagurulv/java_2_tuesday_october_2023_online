package lv.javaguru.java2.cakeConstructor.newApp.core.requests;

public class SearchIngredientsRequest {


    private String type;
    private String taste;

    private Ordering ordering;
    private Paging paging;

    public SearchIngredientsRequest(String type, String taste) {
        this.type = type;
        this.taste = taste;
    }

    public SearchIngredientsRequest(String type, String taste, Ordering ordering) {
        this.type = type;
        this.taste = taste;
        this.ordering = ordering;
    }

    public SearchIngredientsRequest(String type, String taste, Paging paging) {
        this.type = type;
        this.taste = taste;
        this.paging = paging;
    }

    public SearchIngredientsRequest(String type, String taste, Ordering ordering, Paging paging) {
        this.type = type;
        this.taste = taste;
        this.ordering = ordering;
        this.paging = paging;
    }

    public String getType() {
        return type;
    }

    public String getTaste() {
        return taste;
    }

    public boolean isTypeProvided() {
        return this.type != null && !this.type.isEmpty();
    }

    public boolean isTasteProvided() {
        return this.taste != null && !this.taste.isEmpty();
    }

    public Ordering getOrdering() {
        return ordering;
    }

    public Paging getPaging() {
        return paging;
    }
}
