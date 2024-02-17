package lv.javaguru.travel.insurance.rest.v2.agreement;

import lv.javaguru.travel.insurance.rest.v2.TravelCalculatePremiumControllerV2TestCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AgreementLevelV2TestCases extends TravelCalculatePremiumControllerV2TestCase {
    @Test
    @DisplayName("ERROR_CODE_3 agreementDateFrom must not be empty")
    public void executeTestCase14() throws Exception {
        executeAndCompare("agreement/ERROR_CODE_3_agreementDateFrom_is_null");
    }

    @Test
    @DisplayName("ERROR_CODE_6 agreementDateTo must not be empty")
    public void executeTestCase15() throws Exception {
        executeAndCompare("agreement/ERROR_CODE_6_agreementDateTo_is_null");
    }

    @Test
    @DisplayName("ERROR_CODE_4 agreementDateFrom must be in the future")
    public void executeTestCase16() throws Exception {
        executeAndCompare("agreement/ERROR_CODE_4_agreementDateFrom_must_be_in_the_future");
    }

    @Test
    @DisplayName("ERROR_CODE_7 agreementDateTo must be in the future")
    public void executeTestCase17() throws Exception {
        executeAndCompare("agreement/ERROR_CODE_7_agreementDateTo_must_be_in_the_future");
    }

    @Test
    @DisplayName("ERROR_CODE_5 agreementDateFrom must be less than agreementDateTo")
    public void executeTestCase18() throws Exception {
        executeAndCompare("agreement/ERROR_CODE_5_agreementDateFrom_must_be_less_then_agreementDateTo");
    }
    @Test
    @DisplayName("ERROR_CODE_10 country is empty, must not be empty")
    public void executeTestCase23() throws Exception {
        executeAndCompare("agreement/ERROR_CODE_10_country_is_empty");
    }

    @Test
    @DisplayName("ERROR_CODE_10 country is NULL, must not be empty")
    public void executeTestCase24() throws Exception {
        executeAndCompare("agreement/ERROR_CODE_10_country_is_null");
    }

    @Test
    @DisplayName("ERROR_CODE_15 country not supported")
    public void executeTestCase25() throws Exception {
        executeAndCompare("agreement/ERROR_CODE_15_country_not_supported");
    }

}
