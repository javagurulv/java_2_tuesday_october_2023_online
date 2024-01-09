package lv.javaguru.java2.product.storage.core.requests;

public class SearchCustomersRequest {
    private String customerName;

    private String registrationCode;

    private Ordering ordering;

    private Paging paging;

    public SearchCustomersRequest() {
    }

    public SearchCustomersRequest(String customerName, String registrationCode) {
        this.customerName = customerName;
        this.registrationCode = registrationCode;
    }

    public SearchCustomersRequest(String customerName, String registrationCode, Ordering ordering) {
        this.customerName = customerName;
        this.registrationCode = registrationCode;
        this.ordering = ordering;
    }

    public SearchCustomersRequest(String customerName, String registrationCode, Paging paging) {
        this.customerName = customerName;
        this.registrationCode = registrationCode;
        this.paging = paging;
    }

    public SearchCustomersRequest(String customerName, String registrationCode, Ordering ordering, Paging paging) {
        this.customerName = customerName;
        this.registrationCode = registrationCode;
        this.ordering = ordering;
        this.paging = paging;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getRegistrationCode() {
        return registrationCode;
    }

    public void setRegistrationCode(String registrationCode) {
        this.registrationCode = registrationCode;
    }

    public boolean isCustomerNameProvided() {
        return this.customerName != null && !this.customerName.isEmpty();
    }

    public boolean isRegistrationCodeProvided() { return this.registrationCode != null && !this.registrationCode.isEmpty(); }
    public Ordering getOrdering() {
        return ordering;
    }

    public void setOrdering(Ordering ordering) {
        this.ordering = ordering;
    }

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }
}

