package lv.javaguru.travel.insurance.core.repositories;

import lv.javaguru.travel.insurance.core.domain.TravelMedicalMedicalRiskLimitLevel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TravelMedicalMedicalRiskLimitLevelRepository
        extends JpaRepository<TravelMedicalMedicalRiskLimitLevel, Long> {

    Optional<TravelMedicalMedicalRiskLimitLevel> findByMedicalRiskLimitLevelIc(String medicalRiskLimitLevelIc);
}
