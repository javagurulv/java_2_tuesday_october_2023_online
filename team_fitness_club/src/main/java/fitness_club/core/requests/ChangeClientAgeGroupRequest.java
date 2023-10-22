package fitness_club.core.requests;

import fitness_club.core.domain.ClientAgeGroups;


public class ChangeClientAgeGroupRequest {

    private String personalCode;
    private ClientAgeGroups clientAgeGroup;

    public String getPersonalCode() { return personalCode; }
    public ClientAgeGroups getClientAgeGroup() { return clientAgeGroup; }

    public ChangeClientAgeGroupRequest(String personalCode, ClientAgeGroups clientAgeGroup) {
        this.personalCode = personalCode;
        this.clientAgeGroup = clientAgeGroup;
    }


}
