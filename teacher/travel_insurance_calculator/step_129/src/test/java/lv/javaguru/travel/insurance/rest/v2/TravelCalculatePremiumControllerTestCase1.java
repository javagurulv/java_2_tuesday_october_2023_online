package lv.javaguru.travel.insurance.rest.v2;

import org.junit.jupiter.api.Test;

public class TravelCalculatePremiumControllerTestCase1 extends TravelCalculatePremiumControllerV2TestCase {

    @Test
    public void execute() throws Exception {
        executeAndCompare(true);
    }

    @Override
    protected String getTestCaseFolderName() {
        return "test_case_1";
    }
}
