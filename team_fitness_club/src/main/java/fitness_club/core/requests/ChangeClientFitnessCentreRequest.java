package fitness_club.core.requests;

import fitness_club.core.domain.FitnessCentre;


public class ChangeClientFitnessCentreRequest {

    private String personalCode;
    private Long fitnessCentre;

    public String getPersonalCode() {
        return personalCode;
    }

    public Long getFitnessCentre() {
        return fitnessCentre;
    }

    public ChangeClientFitnessCentreRequest(String personalCode, Long fitnessCentre) {
        this.personalCode = personalCode;
        this.fitnessCentre = fitnessCentre;
    }
}
