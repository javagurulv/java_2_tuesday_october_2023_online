package lv.avangardteen.core.service;

import lv.avangardteen.Client;
import lv.avangardteen.UserSizes;
import lv.avangardteen.Wheelchair;
import lv.avangardteen.WheelchairComponent;
import lv.avangardteen.data.DataOrders;
import org.junit.jupiter.api.BeforeEach;

import javax.xml.validation.Validator;

import static org.junit.jupiter.api.Assertions.*;

class ChangeComponentServiceTest {

    DataOrders dataOrders = new DataOrders();
    ChooseComponentValidator validator = new ChooseComponentValidator();
    ChangeComponentService service = new ChangeComponentService(dataOrders, validator);
    @BeforeEach
    public void setUp() {
        DataOrders dataOrders = new DataOrders();
        Client client = new Client();
        client.setNameSurname("AAAAAA");
        client.setPhoneNumber(2222);
        client.setUserAddress("gghhhh");
        client.setUserSizes(new UserSizes(33, 11, 11, 11));
        client.setWheelchair(new Wheelchair(new UserSizes(33, 11, 11, 11)));
        client.setWheelchairComponents(new WheelchairComponent());
        client.getWheelchairComponents().addComponents(11);
        client.getWheelchairComponents().addComponents(21);
        client.getWheelchairComponents().addComponents(31);
        client.getWheelchairComponents().addComponents(41);
        dataOrders.addUser(client);

        Client client1 = dataOrders.getClient(1);
        client1.getWheelchairComponents().addComponents(12);
        client1.getWheelchairComponents().addComponents(22);
        client1.getWheelchairComponents().addComponents(32);
        client1.getWheelchairComponents().addComponents(42);
        System.out.println(dataOrders.getClient(1));
    }


}