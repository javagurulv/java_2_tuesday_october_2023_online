package fitness_club.core.responses;

import fitness_club.core.domain.Client;
import fitness_club.core.domain.FitnessCenter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetFitnessCenterResponse extends CoreResponse {
    private FitnessCenter fitnessCenter;

    public GetFitnessCenterResponse(List<CoreError> errors) {
        super(errors);
    }
}
