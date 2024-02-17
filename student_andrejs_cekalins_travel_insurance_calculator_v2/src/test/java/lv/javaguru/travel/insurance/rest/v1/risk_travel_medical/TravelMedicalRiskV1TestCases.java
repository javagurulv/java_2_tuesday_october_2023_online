package lv.javaguru.travel.insurance.rest.v1.risk_travel_medical;

import lv.javaguru.travel.insurance.rest.v1.TravelCalculatePremiumControllerV1TestCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TravelMedicalRiskV1TestCases extends TravelCalculatePremiumControllerV1TestCase {
    @Test
    @DisplayName("Success case with TRAVEL_MEDICAL risk only")
    public void executeTestCase1() throws Exception {
        executeAndCompare("risk_travel_medical/Success_case_with_TRAVEL_MEDICAL_risk_only",true);
    }

}
