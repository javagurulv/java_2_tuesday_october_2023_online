package lv.javaguru.travel.insurance.core.repositories;

import lv.javaguru.travel.insurance.core.domain.TravelMedicalAgeCoefficient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TravelMedicalAgeCoefficientRepository
        extends JpaRepository<TravelMedicalAgeCoefficient, Long> {

    @Query("SELECT ac from TravelMedicalAgeCoefficient ac " +
            "where ac.ageFrom <= :age " +
            "and ac.ageTo >= :age")
    Optional<TravelMedicalAgeCoefficient> findCoefficient(@Param("age") Integer age);
}
