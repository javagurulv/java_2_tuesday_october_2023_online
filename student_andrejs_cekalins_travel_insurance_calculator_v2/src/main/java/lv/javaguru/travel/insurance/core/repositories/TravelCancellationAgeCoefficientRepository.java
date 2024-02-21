package lv.javaguru.travel.insurance.core.repositories;

import lv.javaguru.travel.insurance.core.domain.TravelCancellationAgeCoefficient;
import lv.javaguru.travel.insurance.core.domain.TravelMedicalAgeCoefficient;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TravelCancellationAgeCoefficientRepository
        extends JpaRepository<TravelCancellationAgeCoefficient, Long> {
    @Cacheable(cacheNames = {"travelCancellationAgeCoefficientCache"}, key = "#p0", unless = "result == null")

    @Query("SELECT ac from TravelCancellationAgeCoefficient ac " +
            "WHERE ac.ageFrom <= :age " +
            "AND ac.ageTo >= :age")
    Optional<TravelCancellationAgeCoefficient> findCoefficient(@Param("age") Integer age);
}
