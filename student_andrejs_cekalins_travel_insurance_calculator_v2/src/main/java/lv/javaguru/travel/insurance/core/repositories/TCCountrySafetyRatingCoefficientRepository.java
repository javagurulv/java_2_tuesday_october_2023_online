package lv.javaguru.travel.insurance.core.repositories;


import lv.javaguru.travel.insurance.core.domain.TravelCancellationCountrySafetyRatingCoefficient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TCCountrySafetyRatingCoefficientRepository
        extends JpaRepository<TravelCancellationCountrySafetyRatingCoefficient, Long> {

    Optional<TravelCancellationCountrySafetyRatingCoefficient> findByCountryIc(String countryIc);
}
