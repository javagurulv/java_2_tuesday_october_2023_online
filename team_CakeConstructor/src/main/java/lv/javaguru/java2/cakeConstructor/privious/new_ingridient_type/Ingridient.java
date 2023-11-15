package lv.javaguru.java2.cakeConstructor.privious.new_ingridient_type;

public class Ingridient {
    private String typeOfIngridient;
    private String taste;

    public Ingridient(){}


    public Ingridient(String type, String taste){
        this.typeOfIngridient=type;
        this.taste=taste;
    }
    public String getTypeOfIngridient() {
        return typeOfIngridient;
    }

    public void setTypeOfIngridient(String typeOfIngridient) {
        this.typeOfIngridient = typeOfIngridient;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

}
