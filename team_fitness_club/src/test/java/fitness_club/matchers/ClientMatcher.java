package fitness_club.matchers;

import fitness_club.core.domain.Client;
import org.mockito.ArgumentMatcher;

public class ClientMatcher implements ArgumentMatcher<Client> {

    private String firstName;
    private String lastName;
    private String personalCode;

    public ClientMatcher(String firstName, String lastName, String personalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalCode = personalCode;


    }

    @Override
    public boolean matches(Client client) {
        return client.getFirstName().equals(firstName)
                && client.getLastName().equals(lastName)
                && client.getPersonalCode().equals(personalCode);
    }
}
