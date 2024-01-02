package fitness_club.core.requests;


public class ChangeClientAgeGroupRequest {

    private String personalCode;
    private Long clientAgeGroup;

    public String getPersonalCode() { return personalCode; }
    public Long getClientAgeGroup() { return clientAgeGroup; }

    public ChangeClientAgeGroupRequest(String personalCode, Long clientAgeGroup) {
        this.personalCode = personalCode;
        this.clientAgeGroup = clientAgeGroup;
    }


}
