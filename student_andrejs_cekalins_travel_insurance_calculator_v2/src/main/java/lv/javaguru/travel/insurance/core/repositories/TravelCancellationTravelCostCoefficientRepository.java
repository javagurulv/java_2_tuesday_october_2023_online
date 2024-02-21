package lv.javaguru.travel.insurance.core.repositories;

import lv.javaguru.travel.insurance.core.domain.TravelCancellationTravelCostCoefficient;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.Optional;

public interface TravelCancellationTravelCostCoefficientRepository
        extends JpaRepository<TravelCancellationTravelCostCoefficient,Long> {
    @Cacheable(cacheNames = {"tCancellationTravelCostCoefficientCache"}, key = "#p0", unless = "#result == null")
    @Query("SELECT tc from TravelCancellationTravelCostCoefficient tc " +
            "where tc.travelCostFrom <= :travelCost " +
            "and tc.travelCostTo >= :travelCost")
    Optional<TravelCancellationTravelCostCoefficient> findCoefficient(@Param("travelCost") BigDecimal travelCost);

}
