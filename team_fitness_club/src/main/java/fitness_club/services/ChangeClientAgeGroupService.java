package fitness_club.services;
import fitness_club.database.Database;
import fitness_club.domain.Client;
import fitness_club.domain.ClientAgeGroups;

import java.util.List;

public class ChangeClientAgeGroupService {

    private Database database;

    public ChangeClientAgeGroupService(Database database) {
        this.database = database;
    }

    public void changeClientAgeGroup(String personalCode, ClientAgeGroups clientAgeGroups) {
        Client clientToChangeWorkout = new Client(personalCode);
        List<Client> clients = database.getAllClients();
        for (Client client: clients) {
            if (client.equals(clientToChangeWorkout)) {
                client.setClientAgeGroup(clientAgeGroups);
                database.saveClient(clients);
                break;
            }
        }
    }
}
