package lv.javaguru.java2.cakeConstructor.newApp.core.request;

public class SearchIngridientRequest {

    private String typeOfIngridient;
    private String  tasteOfIngridient;

    public String getTypeOfIngridient() {
        return typeOfIngridient;
    }

    public String getTasteOfIngridient() {
        return tasteOfIngridient;
    }

    public SearchIngridientRequest (String typeOfIngridient, String tasteOfIngridient){
        this.typeOfIngridient=typeOfIngridient;
        this.tasteOfIngridient=tasteOfIngridient;
    }
    public boolean isTypeProvided() {
        return this.typeOfIngridient != null && !this.typeOfIngridient.isEmpty();
    }

    public boolean isTasteProvided() {
        return this.tasteOfIngridient!= null && !this.tasteOfIngridient.isEmpty();
    }

}
