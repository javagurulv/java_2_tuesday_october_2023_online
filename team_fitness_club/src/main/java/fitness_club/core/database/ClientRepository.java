package fitness_club.core.database;

import fitness_club.core.domain.Client;

import java.util.List;

public interface ClientRepository {
    void save(Client client);

    boolean deleteByPersonalCode(String personalCode);

    List<Client> getAllClients();

    Long getClientIdByPersonalCode(String personalCode);

    List<Client> findByFirstName(String firsName);

    List<Client> findByLastName(String lastName);

    List<Client> findByFirstNameAndLastName(String firstName, String lastName);

    List<Client> findByPersonalCode(String personalCode);
}
