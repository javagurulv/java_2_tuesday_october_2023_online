package lv.javaguru.travel.insurance.core.repositories.entities;

import lv.javaguru.travel.insurance.core.domain.entities.AgreementEntity;
import lv.javaguru.travel.insurance.core.domain.entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AgreementEntityRepository extends JpaRepository<AgreementEntity, Long> {

    /*@Query("SELECT pae from AgreementEntity ae " +
            "where ae.agreementDateFrom = :agreementDateFrom " +
            "      and ae.agreementDateTo = :agreementDateTo " +
            "      and ae.country = :country" +
            "      and ae.agreementPremium = :agreementPremium "
    )
    Optional<PersonEntity> findBy(
            @Param("agreementDateFrom") String agreementDateFrom,
            @Param("agreementDateTo") String agreementDateTo,
            @Param("country") String country,
            @Param("agreementPremium") String agreementPremium
    );

     */
}
