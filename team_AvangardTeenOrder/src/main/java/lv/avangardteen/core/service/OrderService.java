package lv.avangardteen.core.service;

import lv.avangardteen.core.database.*;
import lv.avangardteen.core.domain.*;
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

        userSizeDb.addUserSize(new UserSizes((client.getId()), request.getPelvisWidth(),
                request.getThighLength(), request.getShinLength(), request.getBackHeight()));

        Wheelchair wheelchairSaveToDb = new Wheelchair(client.getId(), wheelchair.getSeatWidth(), wheelchair.getSeatDepth(),
                wheelchair.getFootrestLength(), wheelchair.getBachHeight(), 177000.0);

         wheelchairDB.addWheelchair(wheelchairSaveToDb);


        List<Components> componentList = new ArrayList<>();
        Components componentsFrontWheel = dataComponents.getComponent(4);
        Components componentsBackWheel = dataComponents.getComponent(11);
        Components componentsBrake = dataComponents.getComponent(1);
        Components componentsFootrest = dataComponents.getComponent(15);
        componentList.add(componentsFrontWheel);
        componentList.add(componentsBackWheel);
        componentList.add(componentsBrake);
        componentList.add(componentsFootrest);

        WheelchairComponents wheelchairComponents1 = new WheelchairComponents();
        wheelchairComponents1.setWheelchair(wheelchairSaveToDb);
        wheelchairComponents1.setComponents(componentsFrontWheel);
        WheelchairComponents wheelchairComponents2 = new WheelchairComponents();
        wheelchairComponents2.setWheelchair(wheelchairSaveToDb);
        wheelchairComponents2.setComponents(componentsBackWheel);
        WheelchairComponents wheelchairComponents3 = new WheelchairComponents();
        wheelchairComponents3.setWheelchair(wheelchairSaveToDb);
        wheelchairComponents3.setComponents(componentsBrake);
        WheelchairComponents wheelchairComponents4 = new WheelchairComponents();
        wheelchairComponents4.setWheelchair(wheelchairSaveToDb);
        wheelchairComponents4.setComponents(componentsFootrest);

        componentsDB.addWheelchairComponents(wheelchairComponents1);
        componentsDB.addWheelchairComponents(wheelchairComponents2);
        componentsDB.addWheelchairComponents(wheelchairComponents3);
        componentsDB.addWheelchairComponents(wheelchairComponents4);

        response.setIdOrder(wheelchairSaveToDb.getId());
        response.setClient(client);
        response.setUserSizes(new UserSizes((client.getId()), request.getPelvisWidth(),
                request.getThighLength(), request.getShinLength(), request.getBackHeight()));
        response.setWheelchair(new Wheelchair(client.getId(), wheelchair.getSeatWidth(), wheelchair.getSeatDepth(),
                wheelchair.getFootrestLength(), wheelchair.getBachHeight(), 177000.0));
        response.setListComponents(componentList);

        return response;
    }

    private Client getClient(OrderRequest request) {
        return database.findBySurnameAndPersonalCode(request.getUserName(), request.getUserPersonalCode());
    }

}
