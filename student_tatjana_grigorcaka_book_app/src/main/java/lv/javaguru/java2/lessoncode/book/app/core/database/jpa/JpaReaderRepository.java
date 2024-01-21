package lv.javaguru.java2.lessoncode.book.app.core.database.jpa;

import lv.javaguru.java2.lessoncode.book.app.core.domain.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaReaderRepository extends JpaRepository<Reader, Long> {

    List<Reader> findByFirstName(String firstName);

    @Query("SELECT r FROM Reader r WHERE r.firstName LIKE %:firstName%")
    List<Reader> findByFirstNameLike(@Param("firstName") String firstName);

    @Query(value = "select * from readers where lastName = :lastName", nativeQuery = true)
    List<Reader> findByLastName(@Param("lastName") String lastName);

    @Query("SELECT r FROM Reader r WHERE r.lastName LIKE %:lastName%")
    List<Reader> findByLastNameLike(@Param("lastName") String lastName);

    List<Reader> findByFirstNameAndLastName(String firstName, String lastName);

    @Query("SELECT r FROM Reader r WHERE r.firstName LIKE %:firstName% AND r.lastName LIKE %:lastName%")
    List<Reader> findByFirstNameAndLastNameLike(@Param("firstName") String firstName,
                                                @Param("lastName") String lastName);

    List<Reader> findByFirstNameAndLastNameAndPersonalCode(String firstName, String lastName, String personalCode);


    @Query("SELECT r FROM Reader r WHERE r.firstName LIKE %:firstName% AND r.lastName LIKE %:lastName% AND r.personalCode LIKE %:personalCode%")
    List<Reader> findByFirstNameAndLastNameAndPersonalCodeLike(@Param("firstName") String firstName,
                                                               @Param("lastName") String lastName,
                                                               @Param("personalCode") String personalCode);

}
