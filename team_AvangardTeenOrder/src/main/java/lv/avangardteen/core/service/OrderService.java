package lv.avangardteen.core.service;

import lv.avangardteen.core.database.*;
import lv.avangardteen.core.domain.Client;
import lv.avangardteen.core.domain.Components;
import lv.avangardteen.core.domain.UserSizes;
import lv.avangardteen.core.domain.Wheelchair;
import lv.avangardteen.core.request.OrderRequest;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.core.responce.OrderResponse;
import lv.avangardteen.core.service.validate.OrderValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class OrderService {
    @Autowired
    private Database database;
    @Autowired
    private UserSizeDb userSizeDb;
    @Autowired
    private WheelchairDB wheelchairDB;
    @Autowired
    private WComponentsDB componentsDB;
    @Autowired
    private DataComponents dataComponents;
    @Autowired
    private OrderValidator validator;
    @Autowired
    private CalculateDimensionsWheelchair dimensionsWheelchair;

    public OrderResponse execute(OrderRequest request) {
        List<CoreError> errors = validator.validate(request);
        return (!errors.isEmpty())
                ? new OrderResponse(errors)
                : buildOrderResponse(request);

    }

    private OrderResponse buildOrderResponse(OrderRequest request) {
        OrderResponse response = new OrderResponse();

        Client client = getClient(request);
        Wheelchair wheelchair = dimensionsWheelchair.setDimensions(request.getPelvisWidth(),
                request.getThighLength(), request.getShinLength(), request.getBackHeight());

        userSizeDb.addUserSize(new UserSizes((client), request.getPelvisWidth(),
                request.getThighLength(), request.getShinLength(), request.getBackHeight()));

        Long idWheelchair = wheelchairDB.addWheelchair(new Wheelchair(client, wheelchair.getSeatWidth(), wheelchair.getSeatDepth(),
                wheelchair.getFootrestLength(), wheelchair.getBachHeight(), 177000.0));


        List<Components> componentList = new ArrayList<>();
        Components componentsFrontWheel = dataComponents.getComponent(4);
        Components componentsBackWheel = dataComponents.getComponent(11);
        Components componentsBrake = dataComponents.getComponent(1);
        Components componentsFootrest = dataComponents.getComponent(15);
        componentList.add(componentsFrontWheel);
        componentList.add(componentsBackWheel);
        componentList.add(componentsBrake);
        componentList.add(componentsFootrest);

        componentsDB.addWheelchairComponents(wheelchairDB.getWheelchair(idWheelchair), componentsFrontWheel);
        componentsDB.addWheelchairComponents(wheelchairDB.getWheelchair(idWheelchair), componentsBackWheel);
        componentsDB.addWheelchairComponents(wheelchairDB.getWheelchair(idWheelchair), componentsBrake);
        componentsDB.addWheelchairComponents(wheelchairDB.getWheelchair(idWheelchair), componentsFootrest);

        response.setIdOrder(idWheelchair);
        response.setClient(client);
        response.setUserSizes(new UserSizes((client), request.getPelvisWidth(),
                request.getThighLength(), request.getShinLength(), request.getBackHeight()));
        response.setWheelchair(new Wheelchair(client, wheelchair.getSeatWidth(), wheelchair.getSeatDepth(),
                wheelchair.getFootrestLength(), wheelchair.getBachHeight(), 177000.0));
        response.setListComponents(componentList);

        return response;
    }

    private Client getClient(OrderRequest request) {
        return database.findBySurnameAndPersonalCode(request.getUserName(), request.getUserPersonalCode());
    }

}
