package fitness_club.rest.addClient;

import org.junit.jupiter.api.Test;

public class FitnessClubControllerAddClientTestCase4 extends
        FitnessClubControllerAddClientTestCase {
    @Test
    public void execute() throws Exception {
        executeAndCompare();
    }

    @Override
    protected String getTestCaseFolderName() {
        return "add_client_test_case_4";
    }
}
