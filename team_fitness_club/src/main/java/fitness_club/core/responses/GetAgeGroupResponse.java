package fitness_club.core.responses;

import fitness_club.core.domain.AgeGroups;

import java.util.List;

public class GetAgeGroupResponse extends CoreResponse {

    private List<AgeGroups> ageGroups;

    public GetAgeGroupResponse(List<AgeGroups> ageGroups) {
        this.ageGroups = ageGroups;
    }

    public List<AgeGroups> getAgeGroups() {
        return ageGroups;
    }
}
