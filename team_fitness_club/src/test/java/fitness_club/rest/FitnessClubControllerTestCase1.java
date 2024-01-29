package fitness_club.rest;

import org.junit.jupiter.api.Test;

public class FitnessClubControllerTestCase1 extends
        FitnessClubControllerTestCase {
    @Test
    public void execute() throws Exception {
        executeAndCompare();
    }

    @Override
    protected String getTestCaseFolderName() {
        return "test_case_1";
    }
}
