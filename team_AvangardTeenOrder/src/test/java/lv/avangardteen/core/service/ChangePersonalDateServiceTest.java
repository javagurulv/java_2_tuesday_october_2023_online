package lv.avangardteen.core.service;

import lv.avangardteen.Client;
import lv.avangardteen.UserSizes;
import lv.avangardteen.Wheelchair;
import lv.avangardteen.WheelchairComponent;
import lv.avangardteen.core.request.ChangePersonalDateRequest;
import lv.avangardteen.core.responce.ChangePersonalDateResponse;
import lv.avangardteen.core.responce.CoreError;
import lv.avangardteen.data.DataOrders;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class ChangePersonalDateServiceTest {
    DataOrders dataOrders = new DataOrders();
    ChangePersonalDateValidator validator = new ChangePersonalDateValidator();
    ChangePersonalDateService service = new ChangePersonalDateService(dataOrders, validator);


    public Client setClient() {
        Client client = new Client();
        client.setNameSurname("FFFFFF");
        client.setPhoneNumber(2222222);
        client.setUserAddress("BBBBBBB");
        client.setUserSizes(new UserSizes(33, 33, 33, 33));
        client.setWheelchair(new Wheelchair(new UserSizes(33, 33, 33, 33)));
        client.setWheelchairComponents(new WheelchairComponent());
        client.getWheelchairComponents().addComponents(11);
        client.getWheelchairComponents().addComponents(21);
        client.getWheelchairComponents().addComponents(31);
        client.getWheelchairComponents().addComponents(41);

       return client;

    }


    @Test
    public void addressChange() {
        dataOrders.addUser(setClient());
        ChangePersonalDateRequest request = new ChangePersonalDateRequest(1, "DDDDD", 3333, "NNNNN");
        ChangePersonalDateResponse response = service.execute(request);
        String name = response.getClient().getUserAddress();
        assertEquals(name, "NNNNN");

    }

    @Test
    public void phoneChange() {
        dataOrders.addUser(setClient());
        ChangePersonalDateRequest request = new ChangePersonalDateRequest(1, "DDDDD", 3333, "NNNNN");
        ChangePersonalDateResponse response = service.execute(request);
        int phone = response.getClient().getPhoneNumber();
        assertEquals(phone, 3333);
    }

    @Test
    public void nameIsEmpty() {

        ChangePersonalDateRequest request = new ChangePersonalDateRequest(1, "", 3333, "NNNNN");
        ChangePersonalDateResponse response = service.execute(request);
        List<CoreError> errorList = response.getErrors();
        assertEquals(errorList.size(), 1);
        assertEquals(errorList, List.of(new CoreError("nameSurname", "Must not be empty!")));

    }

    @Test
    public void nameAndAddressIsEmpty() {
        setClient();
        ChangePersonalDateRequest request = new ChangePersonalDateRequest(1, "", 3333, "");
        ChangePersonalDateResponse response = service.execute(request);
        List<CoreError> errorList = response.getErrors();
        assertEquals(errorList.size(), 2);
        assertEquals(errorList, List.of(new CoreError("nameSurname", "Must not be empty!"),
                new CoreError("userAddress", "Must not be empty!")));

    }

    @Test
    public void idIsEmpty() {
        setClient();
        ChangePersonalDateRequest request = new ChangePersonalDateRequest(0, "DDDD", 3333, "HHHHHH");
        ChangePersonalDateResponse response = service.execute(request);
        List<CoreError> errorList = response.getErrors();
        assertEquals(errorList.size(), 1);
        assertEquals(errorList, List.of(new CoreError("idClient", "Must not be zero!")));

    }


}