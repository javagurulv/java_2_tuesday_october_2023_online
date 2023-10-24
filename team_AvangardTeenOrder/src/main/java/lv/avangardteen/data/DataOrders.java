package lv.avangardteen.data;

import lv.avangardteen.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DataOrders {
    List<Client> clients = new ArrayList<>();


    public List<Client> getClients() {

        return clients;
    }
    public void addUser (Client user){

        clients.add(user);
    }

    public Client getClient(long id) {
        List<Client> clients = getClients();
        Client user = null;
        for (Client client : clients) {
            if(client.getId() == id) {
                user = client;
            }
        }
        return user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataOrders that = (DataOrders) o;
        return Objects.equals(clients, that.clients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clients);
    }

    @Override
    public String toString() {
        return "DataOrders{" +
                "clients=" + clients +
                '}';
    }
}
