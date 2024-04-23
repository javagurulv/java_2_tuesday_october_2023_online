package lv.javaguru.travel.insurance.core.repositories.entities;


import lv.javaguru.travel.insurance.core.domain.entities.AgreementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AgreementEntityRepository extends JpaRepository<AgreementEntity, Long> {

    Optional<AgreementEntity> findByUuid(String uuid);

    @Query(nativeQuery = true, value = "SELECT agr.uuid " +
            "FROM agreements agr " +
            "WHERE agr.uuid NOT IN (SELECT agreement_uuid FROM agreements_xml_export)")
    List<String> getNotExportedAgreementUuids();

}
