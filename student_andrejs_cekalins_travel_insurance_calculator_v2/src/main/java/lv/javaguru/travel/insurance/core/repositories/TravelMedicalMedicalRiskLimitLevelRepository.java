package lv.javaguru.travel.insurance.core.repositories;

import lv.javaguru.travel.insurance.core.domain.TravelMedicalMedicalRiskLimitLevel;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TravelMedicalMedicalRiskLimitLevelRepository
        extends JpaRepository<TravelMedicalMedicalRiskLimitLevel, Long> {
    @Cacheable(cacheNames = {"tMedicalMedicalRiskLimitLevelCache"}, key = "#p0", unless = "#result == null")
    Optional<TravelMedicalMedicalRiskLimitLevel> findByMedicalRiskLimitLevelIc(String medicalRiskLimitLevelIc);
}
