package fitness_club.core.responses;

import fitness_club.core.domain.AgeGroup;

import java.util.List;

public class GetAllAgeGroupsResponse extends CoreResponse {

    private List<AgeGroup> ageGroups;

    public GetAllAgeGroupsResponse(List<AgeGroup> ageGroups) {
        this.ageGroups = ageGroups;
    }

    public List<AgeGroup> getAgeGroups() {
        return ageGroups;
    }
}
