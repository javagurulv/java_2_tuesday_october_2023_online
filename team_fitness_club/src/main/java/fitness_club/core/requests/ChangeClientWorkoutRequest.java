package fitness_club.core.requests;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ChangeClientWorkoutRequest {

    private Long clientId;
    private Long workoutId;

}
