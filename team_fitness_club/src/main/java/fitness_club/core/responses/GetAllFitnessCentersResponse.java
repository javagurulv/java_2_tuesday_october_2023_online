package fitness_club.core.responses;

import fitness_club.core.domain.FitnessCenter;

import java.util.List;

public class GetAllFitnessCentersResponse extends CoreResponse {

    private List<FitnessCenter> fitnessCenters;

    public GetAllFitnessCentersResponse(List<FitnessCenter> fitnessCenters) {
        this.fitnessCenters = fitnessCenters;
    }

    public List<FitnessCenter> getFitnessCenters() {
        return fitnessCenters;
    }
}
