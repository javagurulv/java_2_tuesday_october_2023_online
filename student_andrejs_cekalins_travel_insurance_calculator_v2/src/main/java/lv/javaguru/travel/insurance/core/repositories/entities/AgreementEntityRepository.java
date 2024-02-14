package lv.javaguru.travel.insurance.core.repositories.entities;

import lv.javaguru.travel.insurance.core.domain.entities.AgreementEntity;
import lv.javaguru.travel.insurance.core.domain.entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AgreementEntityRepository extends JpaRepository<AgreementEntity, Long> {

    Optional<AgreementEntity> findByUuid(String uuid);
}
