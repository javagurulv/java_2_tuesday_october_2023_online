package lv.javaguru.travel.insurance.core.repositories;


import lv.javaguru.travel.insurance.core.domain.TravelCancellationCountrySafetyRatingCoefficient;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TCCountrySafetyRatingCoefficientRepository
        extends JpaRepository<TravelCancellationCountrySafetyRatingCoefficient, Long> {
    @Cacheable(cacheNames = {"tcCountrySafetyRatingCache"}, key = "#p0", unless = "#result == null")

    Optional<TravelCancellationCountrySafetyRatingCoefficient> findByCountryIc(String countryIc);
}
