package lv.avangardteen.data;

import lv.avangardteen.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DataOrders {
    List<Client> clients = new ArrayList<>();
    int id = 0;

    public List<Client> getClients() {

        return clients;
    }

    public int getId() {
        return id;
    }

    public void addUser(Client user) {
        id++;
        clients.add(user);
    }

    public Client getClient(int id) {
        List<Client> clients = getClients();
        return clients.get(id-1);
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
