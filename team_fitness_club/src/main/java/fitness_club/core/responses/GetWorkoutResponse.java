package fitness_club.core.responses;

import fitness_club.core.domain.Workout;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetWorkoutResponse extends CoreResponse {
    private Workout workout;

    public GetWorkoutResponse(List<CoreError> errors) {
        super(errors);
    }
}
