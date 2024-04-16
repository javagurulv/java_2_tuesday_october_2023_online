package lv.javaguru.travel.insurance.rest.v2.risks;

import lv.javaguru.travel.insurance.rest.v2.TravelCalculatePremiumControllerV2TestCase;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RiskLevelV2TestCases extends TravelCalculatePremiumControllerV2TestCase {
    private static final String TEST_FILE_BASE_FOLDER = "risks";

    @Test
    @DisplayName("Success case with [TRAVEL_MEDICAL, TRAVEL_CANCELLATION]")
    public void executeTestCase1() throws Exception {
        executeAndCompare(TEST_FILE_BASE_FOLDER + "/Success_TRAVEL_MEDICAL_TRAVEL_CANCELLATION",true);
    }

    @Test
    @DisplayName("ERROR_CODE_8 selectedRisks is NULL, must not be empty")
    public void check_ERROR_CODE_8_NULL() throws Exception {
        executeAndCompare(TEST_FILE_BASE_FOLDER + "/ERROR_CODE_8_selectedRisks_is_null");
    }

    @Test
    @DisplayName("ERROR_CODE_8 selectedRisks is [], must not be empty")
    public void check_ERROR_CODE_8_EMPTY() throws Exception {
        executeAndCompare(TEST_FILE_BASE_FOLDER + "/ERROR_CODE_8_selectedRisks_is_empty");
    }

    @Test
    public void check_ERROR_CODE_9_one() throws Exception {
        executeAndCompare(TEST_FILE_BASE_FOLDER + "/ERROR_CODE_9_one_invalid_selectedRisk");
    }

    @Test
    @DisplayName("ERROR_CODE_9 two selectedRisks is not supported")
    public void check_ERROR_CODE_9_two() throws Exception {
        executeAndCompare(TEST_FILE_BASE_FOLDER + "/ERROR_CODE_9_two_invalid_selectedRisk");
    }

}
