package lv.javaguru.java2.cakeConstructor.newApp.core.database.jpa;

import lv.javaguru.java2.cakeConstructor.newApp.core.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaClientRepository extends JpaRepository<Client, Long> {

    List<Client> findByFirstName(String firstName);

    @Query("SELECT c FROM Client c WHERE c.firstName LIKE %:firstName%")
    List<Client> findByFirstNameLike(@Param("firstName") String firstName);

    List<Client> findByLastName(String lastName);

    @Query("SELECT c FROM Client c WHERE c.lastName LIKE %:lastName%")
    List<Client> findByLastNameLike(@Param("lastName") String lastName);

    @Query(value = "select * from clients where personal_code = :personalCode", nativeQuery = true)
    List<Client> findByPersonalCode(@Param("personalCode") String personalCode);

    @Query("SELECT c FROM Client c WHERE c.personalCode LIKE %:personalCode%")
    List<Client> findByPersonalCodeLike(@Param("personalCode") String personalCode);

    List<Client> findByFirstNameAndLastName(String fistName, String lastName);

    @Query("SELECT c FROM Client c WHERE c.firstName LIKE %:firstName% AND c.lastName LIKE %:lastName%")
    List<Client> findByFirstNameAndLastNameLike(@Param("firstName") String firstName,
                                                @Param("lastName") String lastName);

    List<Client> findByFirstNameAndLastNameAndPersonalCode(String firstName, String lastName, String registrationCode);

    @Query("SELECT c FROM Client c WHERE c.firstName LIKE %:firstName% AND c.lastName LIKE %:lastName% AND c.personalCode LIKE %:personalCode")
    List<Client> findByFirstNameAndLastNameAndPersonalCodeLike(@Param("firstName") String firstName,
                                                               @Param("lastName") String lastName,
                                                               @Param("personalCode") String personalCode);


}
