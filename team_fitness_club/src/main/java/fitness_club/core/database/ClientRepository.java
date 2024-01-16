package fitness_club.core.database;

import fitness_club.core.domain.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {
    void save(Client client);

    Client findClientById(Long id);

    boolean deleteByPersonalCode(String personalCode);

    List<Client> getAllClients();

    List<Client> findByFirstName(String firsName);

    List<Client> findByLastName(String lastName);

    List<Client> findByFirstNameAndLastName(String firstName, String lastName);

    List<Client> findByPersonalCode(String personalCode);

}
