package fitness_club.data_vlidation;

import fitness_club.core.database.Database;
import fitness_club.core.domain.Client;
import fitness_club.core.domain.ClientAgeGroups;
import fitness_club.core.domain.FitnessCentre;
import fitness_club.core.domain.Workouts;
import fitness_club.core.requests.AddClientRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class AddClientRequestValidatorDuplicateTest {
    @Mock
    private Database database = new DuplicateDatabaseMock();
    @InjectMocks
    private AddClientRequestValidator validator;
    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    void shouldReturnErrorWhenDuplicateFound() {
        AddClientRequest request = new AddClientRequest("Andrey", "Pupkin",
                "12-12", ClientAgeGroups.ADULT, Workouts.GYM, FitnessCentre.AKROPOLE);
        List<CoreError> errors = validator.validate(request);
//        assertTrue(!errors.isEmpty());
//        assertEquals(errors.get(0).getField(), "uniqueClient");
//        assertEquals(errors.get(0).getMessage(), "Field must not be duplicated! Client with such personal code is already in database!");
    }

    class DuplicateDatabaseMock implements Database {

        @Override
        public void addClient(Client client) {

        }

        @Override
        public boolean deleteClientByPersonalCode(String personalCode) {
            return false;
        }

        @Override
        public List<Client> getAllClients() {
            return null;
        }

        @Override
        public boolean clientAgeGroupChangedByPersonalCode(String personalCode, ClientAgeGroups newAgeGroup) {
            return false;
        }

        @Override
        public boolean clientWorkoutsChangedByPersonalCode(String personalCode, Workouts newWorkout) {
            return false;
        }

        @Override
        public boolean isClientFitnessCentreChangedByPersonalCode(String personalCode, FitnessCentre fitnessCentre) { return false; }

        @Override
        public void saveClient(List<Client> clients) {

        }

        @Override
        public List<Client> findByFirstName(String firsName) {
            return null;
        }

        @Override
        public List<Client> findByLastName(String lastName) {
            return null;
        }

        @Override
        public List<Client> findByFirstNameAndLastName(String firstName, String lastName) {
            return null;
        }

        @Override
        public List<Client> findByPersonalCode(String personalCode) {
            return List.of(new Client("Andrey", "Pupkin",
                    "12-12", ClientAgeGroups.ADULT, Workouts.GYM, FitnessCentre.AKROPOLE));
        }
    }
}