package lv.javaguru.java2.cakeConstructor.newApp.core.request;

public class AddIngridientRequest {

    private String typeOfIngridient;
    private String tasteOfIngridient;

    public String getTypeOfIngridient() {
        return typeOfIngridient;
    }

    public String getTasteOfIngridient() {
        return tasteOfIngridient;
    }

    public AddIngridientRequest(String typeOfIngridient, String tasteOfIngridient){
        this.typeOfIngridient=typeOfIngridient;
        this.tasteOfIngridient=tasteOfIngridient;
    }
}
