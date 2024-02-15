package lv.javaguru.travel.insurance.core.repositories;

import lv.javaguru.travel.insurance.core.domain.TravelCancellationAgeCoefficient;
import lv.javaguru.travel.insurance.core.domain.TravelMedicalAgeCoefficient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TravelCancellationAgeCoefficientRepository
        extends JpaRepository<TravelCancellationAgeCoefficient, Long> {

    @Query("SELECT ac from TravelCancellationAgeCoefficient ac " +
            "WHERE ac.ageFrom <= :age " +
            "AND ac.ageTo >= :age")
    Optional<TravelCancellationAgeCoefficient> findCoefficient(@Param("age") Integer age);
}
