package fitness_club.core.database.jpa;

import fitness_club.core.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaClientRepository extends JpaRepository<Client, Long> {

    List<Client> findByFirstName(String firstName);

    @Query("SELECT c FROM Client c WHERE c.personalCode LIKE %:personalCode%")
    List<Client> findByPersonalCodeLike(@Param("personalCode") String personalCode);

    @Query("SELECT c FROM Reader c WHERE c.firstName LIKE %:firstName% AND c.lastName LIKE %:lastName%")
    List<Client> findByFirstNameAndLastNameLike(@Param("firstName") String firstName,
                                                @Param("lastName") String lastName);

}
