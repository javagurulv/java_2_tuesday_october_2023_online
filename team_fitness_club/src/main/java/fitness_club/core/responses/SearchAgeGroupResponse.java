package fitness_club.core.responses;

import fitness_club.core.domain.AgeGroup;
import fitness_club.core.domain.Client;

import java.util.List;

public class SearchAgeGroupResponse extends CoreResponse {
    private List<AgeGroup> foundAgeGroups;
    public SearchAgeGroupResponse(List<AgeGroup> foundAgeGroups, List<CoreError> errors) {
        super(errors);
        this.foundAgeGroups = foundAgeGroups;
    }

    public List<AgeGroup> foundAgeGroups() { return foundAgeGroups; }
}
