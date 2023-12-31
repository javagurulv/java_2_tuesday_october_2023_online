package fitness_club.core.database.old;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import fitness_club.core.database.ClientRepository;
import fitness_club.core.domain.Client;
import fitness_club.core.domain.AgeGroups;

public class InFileClientRepositoryImpl implements ClientRepository {
    private AgeGroups ageGroups;
    private final String filename;
    private List<Client> clients = new ArrayList<>();

    public InFileClientRepositoryImpl() {
        this.filename = ".\\team_fitness_club\\src\\main\\java\\fitness_club\\core\\database\\ClientsFile.bin";
    }

    public void save(Client client) {
        List<Client> clients = getAllClients();
        client.setId(generateNextId(clients));
        clients.add(client);
        saveClient(clients);
    }

    @Override
    public Optional<Client> findClintById(Long id) {
        return Optional.empty();
    }

    public boolean deleteByPersonalCode(String personalCode) {
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
    public Long getClientIdByPersonalCode(String personalCode){return 0L;}
    /*@Override
    public boolean clientAgeGroupChangedByPersonalCode(String personalCode, ClientAgeGroups newAgeGroup) {
        loadClientsFromFile();
        Optional<Client> clientToChangeAgeGroupOpt = clients.stream()
                .filter(client -> client.getPersonalCode().equals(personalCode))
                .findFirst();
        if (clientToChangeAgeGroupOpt.isPresent()) {
            Client clientToChangeAgeGroup = clientToChangeAgeGroupOpt.get();
            clientToChangeAgeGroup.setClientAgeGroup(newAgeGroup);
            updateClientIds(clients);
            saveClient(clients);
            return true;
        } else {
            return false;
        }
    }



    @Override
    public boolean clientWorkoutsChangedByPersonalCode(String personalCode, Workouts newWorkout) {
        loadClientsFromFile();
        Optional<Client> clientToChangeWorkoutOpt = clients.stream()
                .filter(client -> client.getPersonalCode().equals(personalCode))
                .findFirst();
        if (clientToChangeWorkoutOpt.isPresent()) {
            Client clientToChangeWorkout = clientToChangeWorkoutOpt.get();
            clientToChangeWorkout.setWorkouts(newWorkout);
            updateClientIds(clients);
            saveClient(clients);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isClientFitnessCentreChangedByPersonalCode(String personalCode, FitnessCentre newFitnessCentre) {
        loadClientsFromFile();
        Optional<Client> clientToChangeFitnessCentreOpt = clients.stream()
                .filter(client -> client.getPersonalCode().equals(personalCode))
                .findFirst();
        if (clientToChangeFitnessCentreOpt.isPresent()) {
            Client clientToChangeFitnessCentre = clientToChangeFitnessCentreOpt.get();
            clientToChangeFitnessCentre.setFitnessCentre(newFitnessCentre);
            updateClientIds(clients);
            saveClient(clients);
            return true;
        } else {
            return false;
        }
    }

     */



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

    @Override
    public List<Client> findByPersonalCode(String personalCode) {
        return getAllClients().stream()
                .filter(client -> client.getPersonalCode().equals(personalCode))
                .collect(Collectors.toList());
    }

    @Override
    public boolean findUniqueClient(String personalCode) {
        return false;
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
