package fitness_club.requests;

import fitness_club.domain.ClientAgeGroups;


public class ChangeClientAgeGroupRequest {

    private String personalCode;
    private ClientAgeGroups clientAgeGroup;

    public ChangeClientAgeGroupRequest(String personalCode) {
        this.personalCode = personalCode;
    }

    public String getPersonalCode() {
        return personalCode;
    }
}
