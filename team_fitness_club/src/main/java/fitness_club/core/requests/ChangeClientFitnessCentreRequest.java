package fitness_club.core.requests;

import fitness_club.core.domain.FitnessCentre;


public class ChangeClientFitnessCentreRequest {

    private String personalCode;
    private FitnessCentre fitnessCentre;

    public String getPersonalCode() {
        return personalCode;
    }

    public FitnessCentre getFitnessCentre() {
        return fitnessCentre;
    }

    public ChangeClientFitnessCentreRequest(String personalCode, FitnessCentre fitnessCentre) {
        this.personalCode = personalCode;
        this.fitnessCentre = fitnessCentre;
    }
}
