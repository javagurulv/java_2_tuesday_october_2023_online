package lv.javaguru.java2.cakeConstructor.newApp.core.request;

public class SearchIngridientRequest {


    private String typeOfIngridient;
    private String  tasteOfIngridient;

    private Ordering ordering;
    private Paging paging;

    public SearchIngridientRequest(String typeOfIngridient, String tasteOfIngridient, Paging paging) {
        this.typeOfIngridient = typeOfIngridient;
        this.tasteOfIngridient = tasteOfIngridient;
        this.paging = paging;
    }



    public SearchIngridientRequest(String typeOfIngridient, String tasteOfIngridient, Ordering ordering, Paging paging) {
        this.typeOfIngridient = typeOfIngridient;
        this.tasteOfIngridient = tasteOfIngridient;
        this.ordering = ordering;
        this.paging = paging;
    }

    public SearchIngridientRequest(String typeOfIngridient, String tasteOfIngridient, Ordering ordering) {
        this.typeOfIngridient = typeOfIngridient;
        this.tasteOfIngridient = tasteOfIngridient;
        this.ordering = ordering;
    }

    public String getTypeOfIngridient() {
        return typeOfIngridient;
    }

    public String getTasteOfIngridient() {
        return tasteOfIngridient;
    }

    public boolean isTypeProvided() {
        return this.typeOfIngridient != null && !this.typeOfIngridient.isEmpty();
    }

    public boolean isTasteProvided() {
        return this.tasteOfIngridient!= null && !this.tasteOfIngridient.isEmpty();
    }

    public Ordering getOrdering() {
        return ordering;
    }

    public Paging getPaging() {
        return paging;
    }
}
