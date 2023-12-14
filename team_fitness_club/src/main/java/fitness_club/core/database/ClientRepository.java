package fitness_club.core.database;

import fitness_club.core.domain.Client;

import java.util.List;

public interface ClientRepository {
    void save(Client client);

    boolean deleteByPersonalCode(String personalCode);

    List<Client> getAllClients();

   // boolean clientAgeGroupChangedByPersonalCode(String personalCode, ClientAgeGroups newAgeGroup);

   // boolean clientWorkoutsChangedByPersonalCode(String personalCode, Workouts newWorkout);

  //  boolean isClientFitnessCentreChangedByPersonalCode(String personalCode, FitnessCentre fitnessCentre);

    //void saveClient(List<Client> clients);

    List<Client> findByFirstName(String firsName);

    List<Client> findByLastName(String lastName);

    List<Client> findByFirstNameAndLastName(String firstName, String lastName);

    List<Client> findByPersonalCode(String personalCode);
}
