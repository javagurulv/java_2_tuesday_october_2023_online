package lv.javaguru.java2.cakeConstructor.privious.new_ingridient_type;

public class IngridientBuilder {
    private String typeOfIngridient;
    private String taste;

    public static IngridientBuilder createIngridient(){
        return new IngridientBuilder();
    }
    public Ingridient build(){
        return new Ingridient(typeOfIngridient,taste);
    }
    public IngridientBuilder withType(String type){
        this.typeOfIngridient=type;
        return this;
    }

    public IngridientBuilder withTaste(String taste){
        this.taste=taste;
        return this;
    }
}
