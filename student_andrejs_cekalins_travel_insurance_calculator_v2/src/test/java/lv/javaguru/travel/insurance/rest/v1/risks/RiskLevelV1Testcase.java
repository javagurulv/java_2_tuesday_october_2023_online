package lv.javaguru.travel.insurance.rest.v1.risks;

import lv.javaguru.travel.insurance.rest.v1.TravelCalculatePremiumControllerV1TestCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RiskLevelV1Testcase extends TravelCalculatePremiumControllerV1TestCase {
    @Test
    @DisplayName("ERROR_CODE_8 selectedRisks is NULL, must not be empty")
    public void executeTestCase13() throws Exception {
        executeAndCompare("risks/ERROR_CODE_8_selectedRisks_is_null");
    }
    @Test
    @DisplayName("ERROR_CODE_8 selectedRisks is [], must not be empty")
    public void executeTestCase14() throws Exception {
        executeAndCompare("risks/ERROR_CODE_8_selectedRisks_is_empty");
    }
    @Test
    @DisplayName("ERROR_CODE_9 one invalid selected_risks ic not supported")
    public void executeTestCase15() throws Exception {
        executeAndCompare("risks/ERROR_CODE_9_one_invalid_selectedRisk");
    }
    @Test
    @DisplayName("ERROR_CODE_9 two invalid selected_risks not supported")
    public void executeTestCase16() throws Exception {
        executeAndCompare("risks/ERROR_CODE_9_two_invalid_selectedRisk");
    }


}