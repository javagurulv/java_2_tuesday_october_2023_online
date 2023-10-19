package fitness_club.core.database;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import fitness_club.core.domain.Client;

public class InFileDatabase implements Database {

    private final String filename;

    public InFileDatabase() {
        this.filename = ".\\team_fitness_club\\src\\main\\java\\database\\ClientsFile";
    }

    public void addClient(Client client) {
        List<Client> clients = getAllClients();
        client.setId(generateNextId(clients));
        clients.add(client);
        saveClient(clients);
    }

    public void removeClient(String personalCode) {
        List<Client> clients = getAllClients();
        clients.remove(personalCode);
        updateClientIds(clients);
        saveClient(clients);
    }


    public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            clients = (List<Client>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return clients;
    }

    public void saveClient(List<Client> clients) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(clients);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Long generateNextId(List<Client> clients) {
        if (clients.isEmpty()) {
            return 1L;
        } else {
            long maxId = clients.stream().mapToLong(Client::getId).max().orElse(0L);
            return maxId + 1;
        }
    }

    private void updateClientIds(List<Client> clients) {
        for (int i = 0; i < clients.size(); i++) {
            clients.get(i).setId((long) (i + 1));
        }
    }
}
