package lv.javaguru.java2.createCake.core.cake.request_and_response.check_order;

import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.Cake;

import java.util.List;

public class CheckOrderResponse {
    private Cake cake;



    public CheckOrderResponse (Cake cake){
        this.cake=cake;
    }
    public Cake getCake() {
        return cake;
    }
}
