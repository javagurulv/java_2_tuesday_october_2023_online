package lv.javaguru.travel.insurance.rest.v1.person;

import lv.javaguru.travel.insurance.rest.v1.TravelCalculatePremiumControllerV1TestCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PersonLevelV1TestCases extends TravelCalculatePremiumControllerV1TestCase {
    @Test
    @DisplayName("ERROR_CODE_1 personFirstName is NULL")
    public void executeTestCase2() throws Exception {
        executeAndCompare("person/ERROR_CODE_1_personFirstName_is_null");
    }
    @Test
    @DisplayName("ERROR_CODE_1 personFirstName is empty")
    public void executeTestCase3() throws Exception {
        executeAndCompare("person/ERROR_CODE_1_personFirstName_is_empty");
    }
    @Test
    @DisplayName("ERROR_CODE_2 personLastName is NULL")
    public void executeTestCase4() throws Exception {
        executeAndCompare("person/ERROR_CODE_2_personLastName_is_null");
    }
    @Test
    @DisplayName("ERROR_CODE_2 personLastName is empty")
    public void executeTestCase5() throws Exception {
        executeAndCompare("person/ERROR_CODE_2_personLastName_is_empty");
    }
    @Test
    @DisplayName("ERROR_CODE_11 personBirthDate is NULL")
    public void executeTestCase6() throws Exception {
        executeAndCompare("person/ERROR_CODE_11_personBirthDate_is_null");
    }
    @Test
    @DisplayName("ERROR_CODE_12 personBirthDate in the future")
    public void executeTestCase7() throws Exception {
        executeAndCompare("person/ERROR_CODE_12_personBirthDate_in_the_future");
    }
    @Test
    @DisplayName("ERROR_CODE_16 personCode is NULL, must not be empty")
    public void executeTestCase23() throws Exception {
        executeAndCompare("person/ERROR_CODE_16_personCode_is_null");
    }
    @Test
    @DisplayName("ERROR_CODE_16 personCode is empty, must not be empty")
    public void executeTestCase24() throws Exception {
        executeAndCompare("person/ERROR_CODE_16_personCode_is_empty");
    }
}
