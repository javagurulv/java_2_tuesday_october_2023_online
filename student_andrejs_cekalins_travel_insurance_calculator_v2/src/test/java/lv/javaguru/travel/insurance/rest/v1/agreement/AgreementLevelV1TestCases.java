package lv.javaguru.travel.insurance.rest.v1.agreement;

import lv.javaguru.travel.insurance.rest.v1.TravelCalculatePremiumControllerV1TestCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AgreementLevelV1TestCases extends TravelCalculatePremiumControllerV1TestCase {
    @Test
    @DisplayName("ERROR_CODE_3 agreementDateFrom is NULL")
    public void executeTestCase8() throws Exception {
        executeAndCompare("agreement/ERROR_CODE_3_agreementDateFrom_is_null");
    }

    @Test
    @DisplayName("ERROR_CODE_6 agreementDateTo is NULL")
    public void executeTestCase9() throws Exception {
        executeAndCompare("agreement/ERROR_CODE_6_agreementDateTo_is_null");
    }

    @Test
    @DisplayName("ERROR_CODE_4 agreementDateFrom must be in the future")
    public void executeTestCase10() throws Exception {
        executeAndCompare("agreement/ERROR_CODE_4_agreementDateFrom_must_be_in_the_future");
    }

    @Test
    @DisplayName("ERROR_CODE_7 agreementDateTo must be in the future")
    public void executeTestCase11() throws Exception {
        executeAndCompare("agreement/ERROR_CODE_7_agreementDateTo_must_be_in_the_future");
    }

    @Test
    @DisplayName("ERROR_CODE_5 agreementDateFrom must be less than agreementDateTo")
    public void executeTestCase12() throws Exception {
        executeAndCompare("agreement/ERROR_CODE_5_agreementDateFrom_must_be_less_then_agreementDateTo");
    }

    @Test
    @DisplayName("ERROR_CODE_10 TRAVEL_MEDICAL country is empty, must not be empty")
    public void executeTestCase17() throws Exception {
        executeAndCompare("agreement/ERROR_CODE_10_country_is_empty");
    }

    @Test
    @DisplayName("ERROR_CODE_10 TRAVEL_MEDICAL country is NULL, must not be empty")
    public void executeTestCase18() throws Exception {
        executeAndCompare("agreement/ERROR_CODE_10_country_is_null");
    }

    @Test
    @DisplayName("Multiple errors all field is NULL except selected_risks")
    public void executeTestCase19() throws Exception {
        executeAndCompare("agreement/Multiple_errors_all_all_fields_NULL_except_selectedRisks");
    }

    @Test
    @DisplayName("Multiple errors all field is NULL")
    public void executeTestCase20() throws Exception {
        executeAndCompare("agreement/Multiple_errors_all_all_fields_NULL");
    }

    @Test
    @DisplayName("ERROR_CODE_10 TRAVEL_EVACUATION country is NULL, must not be empty")
    public void executeTestCase21() throws Exception {
        executeAndCompare("agreement/ERROR_CODE_10_country_is_null");
    }

    @Test
    @DisplayName("ERROR_CODE_10 TRAVEL_EVACUATION country is empty, must not be empty")
    public void executeTestCase22() throws Exception {
        executeAndCompare("agreement/ERROR_CODE_10_country_is_empty");
    }
}
