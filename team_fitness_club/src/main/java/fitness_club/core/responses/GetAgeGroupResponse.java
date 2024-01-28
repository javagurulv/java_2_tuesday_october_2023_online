package fitness_club.core.responses;

import fitness_club.core.domain.AgeGroup;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetAgeGroupResponse extends CoreResponse {
    private AgeGroup ageGroup;

    public GetAgeGroupResponse(List<CoreError> errors) {
        super(errors);
    }
}
