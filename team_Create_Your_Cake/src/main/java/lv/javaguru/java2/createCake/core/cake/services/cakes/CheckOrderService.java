package lv.javaguru.java2.createCake.core.cake.services.cakes;

import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.Cake;
import lv.javaguru.java2.createCake.core.cake.domain.ingridients.objects.database.ui_users_cakes.UIDatabaseCakes;
import lv.javaguru.java2.createCake.core.cake.request_and_response.check_order.CheckOrderRequest;
import lv.javaguru.java2.createCake.core.cake.request_and_response.check_order.CheckOrderResponse;

import java.util.List;

public class CheckOrderService {

    private UIDatabaseCakes databaseCake;

    public CheckOrderService(UIDatabaseCakes databaseCakes){
        this.databaseCake=databaseCakes;
    }

    public CheckOrderResponse execute(CheckOrderRequest request){
        List <Cake> cakes = databaseCake.getActiveCakeForClient(request.getUserLogin());
        Cake cake = null;
        for (Cake cake1:cakes){
            if (cake1.getStatus()==2|| cake1.getStatus()==3){
                cake=cake1;
            }
        }
        return new CheckOrderResponse(cake);
    }



}
