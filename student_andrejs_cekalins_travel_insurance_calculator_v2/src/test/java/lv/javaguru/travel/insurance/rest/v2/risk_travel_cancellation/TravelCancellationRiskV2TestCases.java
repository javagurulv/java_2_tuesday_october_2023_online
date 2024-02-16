package lv.javaguru.travel.insurance.rest.v2.risk_travel_cancellation;

import lv.javaguru.travel.insurance.rest.v2.TravelCalculatePremiumControllerV2TestCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TravelCancellationRiskV2TestCases extends TravelCalculatePremiumControllerV2TestCase {
    @Test
    @DisplayName("ERROR_CODE_19 two persons travelCost is NULL, must not be empty")
    public void executeTestCase36() throws Exception {
        executeAndCompare("test_case_36");
    }
}
