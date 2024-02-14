package lv.javaguru.travel.insurance.core.repositories;

import lv.javaguru.travel.insurance.core.domain.TravelMedicalCountryDefaultDayRate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TravelMedicalCountryDefaultDayRateRepository
        extends JpaRepository<TravelMedicalCountryDefaultDayRate, Long> {

    Optional<TravelMedicalCountryDefaultDayRate> findByCountryIc(String countryIc);
}
