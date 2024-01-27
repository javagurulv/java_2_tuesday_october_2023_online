package lv.javaguru.java2.cakeConstructor.newApp.core.database;

import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Client;


import java.util.List;
import java.util.Optional;

public interface ClientRepository {

    void save(Client client);

    Client findById(Long id);

    Optional<Client> getById(Long id);

    boolean deleteById(Long id);

    List<Client> getAllClients();

    List<Client> findByFirstName(String firstName);

    List<Client> findByLastName(String lastName);

    List<Client> findByPersonalCode(String personalCode);

    List<Client> findByFirstNameAndLastName(String firstName, String lastName);

    List<Client> findByFirstNameAndLastNameAndPersonalCode(String firstName, String lastName, String personalCode);


}
