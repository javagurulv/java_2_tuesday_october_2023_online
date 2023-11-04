package fitness_club.core.database;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import fitness_club.core.domain.Client;
import fitness_club.core.domain.ClientAgeGroups;
import fitness_club.core.requests.SearchClientRequest;
import fitness_club.core.responses.SearchClientResponse;

public class InFileDatabase implements Database {
    private ClientAgeGroups ageGroups;
    private final String filename;
    private List<Client> clients = new ArrayList<>();

    public InFileDatabase() {
        this.filename = ".\\team_fitness_club\\src\\main\\java\\fitness_club\\core\\database\\ClientsFile.bin";
    }

    public void addClient(Client client) {
        List<Client> clients = getAllClients();
        client.setId(generateNextId(clients));
        clients.add(client);
        saveClient(clients);
    }

    public boolean deleteClientByPersonalCode(String personalCode) {
        boolean isClientDeleted = false;
        Optional<Client> clientToDeleteOpt = clients.stream()
                .filter(client -> client.getPersonalCode().equals(personalCode))
                .findFirst();
        if (clientToDeleteOpt.isPresent()) {
            Client clientToRemove = clientToDeleteOpt.get();
            isClientDeleted = clients.remove(clientToRemove);
            updateClientIds(clients);
            saveClient(clients);
        }
        return isClientDeleted;

    }

    public List<Client> getAllClients() {
        loadClientsFromFile();
        return clients;
    }

    @Override
    public boolean clientAgeGroupChangedByPersonalCode(String personalCode) {
        boolean isClientAgeGroupChanged = false;
        Optional<Client> clientToChangeAgeGroupOpt = clients.stream()
                .filter(client -> client.getPersonalCode().equals(personalCode))
                .findFirst();
        if (clientToChangeAgeGroupOpt.isPresent()) {
            Client clientToChangeAgeGroup = clientToChangeAgeGroupOpt.get();
            isClientAgeGroupChanged = clients.add(clientToChangeAgeGroup);
            updateClientIds(clients);
            saveClient(clients);
        }

        return isClientAgeGroupChanged;
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

    @Override
    public List<Client> findByFirstName(String firstName) {
        return getAllClients().stream()
                .filter(client -> client.getFirstName().equals(firstName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Client> findByLastName(String lastName) {
        return getAllClients().stream()
                .filter(client -> client.getLastName().equals(lastName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Client> findByFirstNameAndLastName(String firstName, String lastName) {
        return getAllClients().stream()
                .filter(client -> client.getFirstName().equals(firstName))
                .filter(client -> client.getLastName().equals(lastName))
                .collect(Collectors.toList());
    }

    private void loadClientsFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            List<Client> loadedClients = (List<Client>) ois.readObject();
            clients.clear();
            clients.addAll(loadedClients);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
