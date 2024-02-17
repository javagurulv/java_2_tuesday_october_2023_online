package lv.javaguru.travel.insurance.rest.v2.risks;

import lv.javaguru.travel.insurance.rest.v2.TravelCalculatePremiumControllerV2TestCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RiskLevelV2TestCases extends TravelCalculatePremiumControllerV2TestCase {
    @Test
    @DisplayName("Success case with [TRAVEL_MEDICAL, TRAVEL_CANCELLATION]")
    public void executeTestCase1() throws Exception {
        executeAndCompare("risks/Success_TRAVEL_MEDICAL_TRAVEL_CANCELLATION", true);
    }

    @Test
    @DisplayName("ERROR_CODE_8 selectedRisks is NULL, must not be empty")
    public void executeTestCase19() throws Exception {
        executeAndCompare("risks/ERROR_CODE_8_selectedRisks_is_null");
    }

    @Test
    @DisplayName("ERROR_CODE_8 selectedRisks is [], must not be empty")
    public void executeTestCase20() throws Exception {
        executeAndCompare("risks/ERROR_CODE_8_selectedRisks_is_empty");
    }

    @Test
    @DisplayName("ERROR_CODE_9 one selectedRisks is not supported")
    public void executeTestCase21() throws Exception {
        executeAndCompare("risks/ERROR_CODE_9_one_invalid_selectedRisk");
    }

    @Test
    @DisplayName("ERROR_CODE_9 two selectedRisks is not supported")
    public void executeTestCase22() throws Exception {
        executeAndCompare("risks/ERROR_CODE_9_two_invalid_selectedRisk");
    }

}
