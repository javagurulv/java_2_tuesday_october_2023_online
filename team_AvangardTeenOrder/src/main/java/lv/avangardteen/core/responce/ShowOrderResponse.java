package lv.avangardteen.core.responce;

import lv.avangardteen.core.domain.Client;
import lv.avangardteen.core.domain.UserSizes;
import lv.avangardteen.core.domain.Wheelchair;
import lv.avangardteen.core.domain.WheelchairComponents;

import java.util.List;


public class ShowOrderResponse extends CoreResponse {


    Wheelchair wheelchair;
    List<WheelchairComponents> wheelchairComponents;
    Double priceWheelchair;
    Double priceComponents;
    Double priceOrder;

    public Double getPriceOrder() {
        return priceOrder;
    }

    public Double getPriceWheelchair() {
        return priceWheelchair;
    }

    public void setPriceWheelchair(Double priceWheelchair) {
        this.priceWheelchair = priceWheelchair;
    }

    public Double getPriceComponents() {
        return priceComponents;
    }

    public void setPriceComponents(Double priceComponents) {
        this.priceComponents = priceComponents;
    }

    public void setPriceOrder(Double priceOrder) {
        this.priceOrder = priceOrder;
    }

    public ShowOrderResponse(List<CoreError> errors) {
        super(errors);
    }

    public ShowOrderResponse() {}

    public Wheelchair getWheelchair() {
        return wheelchair;
    }

    public void setWheelchair(Wheelchair wheelchair) {
        this.wheelchair = wheelchair;
    }

    public List<WheelchairComponents> getWheelchairComponents() {
        return wheelchairComponents;
    }

    public void setWheelchairComponents(List<WheelchairComponents> wheelchairComponents) {
        this.wheelchairComponents = wheelchairComponents;
    }
}
