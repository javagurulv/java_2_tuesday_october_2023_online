package lv.javaguru.travel.insurance.rest.v1;

import lv.javaguru.travel.insurance.rest.v1.TravelCalculatePremiumControllerTestCase;
import org.junit.jupiter.api.Test;

public class TravelCalculatePremiumControllerTestCase21 extends
        TravelCalculatePremiumControllerTestCase {
    @Test
    public void execute() throws Exception {
        executeAndCompare();
    }

    @Override
    protected String getTestCaseFolderName() {
        return "test_case_21";
    }

}