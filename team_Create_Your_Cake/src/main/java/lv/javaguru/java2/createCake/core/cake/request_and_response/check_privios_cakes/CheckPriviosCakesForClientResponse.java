package lv.javaguru.java2.createCake.core.cake.request_and_response.check_privios_cakes;

import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.Cake;

import java.util.List;

public class CheckPriviosCakesForClientResponse {
    private List<Cake>cakes;


    public CheckPriviosCakesForClientResponse (List<Cake>cakes){
        this.cakes=cakes;
    }
    public List<Cake> getCakes() {
        return cakes;
    }

}
