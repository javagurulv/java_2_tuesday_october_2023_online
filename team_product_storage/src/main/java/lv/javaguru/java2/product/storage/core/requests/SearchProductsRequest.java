package lv.javaguru.java2.product.storage.core.requests;

public class SearchProductsRequest {
    private String productBrand;

    private String productModel;

    private Ordering ordering;

    private Paging paging;

    public SearchProductsRequest() {
    }

    public SearchProductsRequest(String productBrand, String productModel) {
        this.productBrand = productBrand;
        this.productModel = productModel;
    }

    public SearchProductsRequest(String productBrand, String productModel, Ordering ordering) {
        this.productBrand = productBrand;
        this.productModel = productModel;
        this.ordering = ordering;
    }

    public SearchProductsRequest(String productBrand, String productModel, Paging paging) {
        this.productBrand = productBrand;
        this.productModel = productModel;
        this.paging = paging;
    }

    public SearchProductsRequest(String productBrand, String productModel, Ordering ordering, Paging paging) {
        this.productBrand = productBrand;
        this.productModel = productModel;
        this.ordering = ordering;
        this.paging = paging;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public String getProductModel() {
        return productModel;
    }

    public boolean isProductBrandProvided() {
        return this.productBrand != null && !this.productBrand.isEmpty();
    }

    public boolean isProductModelProvided() {
        return this.productModel != null && !this.productModel.isEmpty();
    }

    public Ordering getOrdering() {
        return ordering;
    }

    public Paging getPaging() {
        return paging;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel;
    }

    public void setOrdering(Ordering ordering) {
        this.ordering = ordering;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }
}

