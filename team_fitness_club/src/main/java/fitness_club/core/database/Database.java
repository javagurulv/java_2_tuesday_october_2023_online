package fitness_club.core.database;

import fitness_club.core.domain.Client;
import fitness_club.core.domain.ClientAgeGroups;
import fitness_club.core.domain.Workouts;

import java.util.List;

public interface Database {
    void addClient(Client client);

    boolean deleteClientByPersonalCode(String personalCode);

    List<Client> getAllClients();

    boolean clientAgeGroupChangedByPersonalCode(String personalCode, ClientAgeGroups newAgeGroup);
    boolean clientWorkoutsChangedByPersonalCode(String personalCode, Workouts newWorkout);

    void saveClient(List<Client> clients);

    List<Client> findByFirstName(String firsName);

    List<Client> findByLastName(String lastName);

    List<Client> findByFirstNameAndLastName(String firstName, String lastName);

    List<Client> findByPersonalCode(String personalCode);


}
