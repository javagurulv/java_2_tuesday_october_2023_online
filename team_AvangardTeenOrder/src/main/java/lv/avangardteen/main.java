package lv.avangardteen;

import lv.avangardteen.core.data.DataOrders;
import lv.avangardteen.core.data.Database;
import lv.avangardteen.core.dto.Client;
import lv.avangardteen.core.dto.UserSizes;

public class main {
    public static void main(String[] args) {
        Database database = new DataOrders();
        /*Client client = new Client();
        client.setNameSurname("Ivsb");
        client.setPhoneNumber(8884l);
        client.setUserAddress("aaaaa");
        database.addUser(client);*/

        Client client2 = new Client();
        client2.setNameSurname("uuuu");
        client2.setPhoneNumber(8884l);
        client2.setUserAddress("auuuuu");
        database.addUser(client2);

        UserSizes userSizes = new UserSizes();
        userSizes.setShinLength(33);
        userSizes.setBackHeight(33);
        userSizes.setThighLength(33);
        userSizes.setPelvisWidth(33);
        database.addUserSize(userSizes);

        Client client3 = new Client();
        client3.setNameSurname("uuuu");
        client3.setPhoneNumber(8884l);
        client3.setUserAddress("auuuuu");
        database.addUser(client3);

        UserSizes userSizes2 = new UserSizes();
        userSizes2.setShinLength(11);
        userSizes2.setBackHeight(11);
        userSizes2.setThighLength(11);
        userSizes2.setPelvisWidth(11);
        database.addUserSize(userSizes2);

        Client client4 = new Client();
        client4.setNameSurname("uuuu");
        client4.setPhoneNumber(8884l);
        client4.setUserAddress("auuuuu");
        database.addUser(client4);



        //UserSizes userSizes1 = database.getUserSize(1l);
       // System.out.println(userSizes1);
        //  System.out.println(database.toString());
        // Client clientSearch = database.getClient(1l);
        // System.out.println(clientSearch);
          //System.out.println(database.getClients());
          System.out.println(database.getUserSizesOrders());

        UserSizes userSizes3 = new UserSizes();
        userSizes3.setShinLength(55);
        userSizes3.setBackHeight(55);
        userSizes3.setThighLength(55);
        userSizes3.setPelvisWidth(55);
        database.updateUserSize(2l, userSizes3);
         // System.out.println(database.getUserSize(2l));

        System.out.println(database.getUserSizesOrders());
    }
}
