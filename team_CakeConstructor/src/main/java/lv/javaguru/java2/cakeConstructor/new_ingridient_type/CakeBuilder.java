package lv.javaguru.java2.cakeConstructor.new_ingridient_type;


import lv.javaguru.java2.cakeConstructor.core.cake.domain.Cake;
import lv.javaguru.java2.cakeConstructor.core.cake.domain.NewCake;

import java.util.List;
import java.util.ArrayList;

import static lv.javaguru.java2.cakeConstructor.new_ingridient_type.IngridientBuilder.createIngridient;

public class CakeBuilder {
    private Long id;
    private String cakeName;
    private String userLogin;
    private List<Ingridient>ingridiens = new ArrayList<>();

    public static CakeBuilder createCake(){
        return new CakeBuilder();
    }

    public NewCake build(){
        NewCake cake = new NewCake();
        cake.setId(id);
        cake.setCakeName(cakeName);
        cake.setUserLogin(userLogin);
        cake.setIntegers(ingridiens);
        return cake;

    }
    public CakeBuilder withId(Long id){
        this.id=id;
        return this;
    }
    public CakeBuilder withCakeName(String cakeName){
        this.cakeName=cakeName;
        return this;
    }

    public CakeBuilder withUserLogin(String userLogin){
        this.userLogin = userLogin;
        return this;
    }
    public CakeBuilder withIngridient(Ingridient ingridient){
        this.ingridiens.add(ingridient);
        return this;
    }

    public static void main (String[] args) {
        NewCake cake1 = createCake()
                .withId(1L)
                .withCakeName("cake name")
                .withUserLogin("user login")
                .withIngridient(createIngridient()
                        .withType("type")
                        .withTaste("taste")
                        .build())
                .withIngridient(createIngridient()
                        .withType("type")
                        .withTaste("taste")
                        .build())
                .withIngridient(createIngridient()
                        .withType("type")
                        .withTaste("taste")
                        .build())
                .withIngridient(createIngridient()
                        .withType("type")
                        .withTaste("taste")
                        .build())
                .build();
        CakeBuilder cakeBuilder = CakeBuilder.createCake();
        if (6<7){
            cakeBuilder.withId(4L);
        }
        NewCake cake = cakeBuilder.build();
    }
}
