package lv.javaguru.java2.createCake.core.cake.services.users;

import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.Cake;
import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.database.ui_users_cakes.UIDatabaseCakes;
import lv.javaguru.java2.createCake.core.cake.request_and_response.check_privios_cakes.CheckPriviosCakesForClientRequest;
import lv.javaguru.java2.createCake.core.cake.request_and_response.check_privios_cakes.CheckPriviosCakesForClientResponse;

import java.util.List;

public class CheckPriviosCakesService {
    private UIDatabaseCakes databaseCakes;

    public CheckPriviosCakesService(UIDatabaseCakes databaseCakes){
        this.databaseCakes=databaseCakes;
    }
    public CheckPriviosCakesForClientResponse execute(CheckPriviosCakesForClientRequest request){
        List<Cake> cakes = databaseCakes.getAllCakes();
        List<Cake> cake1 = null;
        for (Cake cake : cakes) {
            if (request.getUserLogin().equals(cake.getUserLogin())) {
                cake1.add(cake);
            }
        }
        return new CheckPriviosCakesForClientResponse(cake1);
    }
}
