package fitness_club.core.requests;

import fitness_club.core.domain.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UpdateMemberCardRequest {

    private Long id;
    private String newClient;
    private Long newAgeGroup;
    private Long newWorkout;
    private Long newFitnessCenter;
    private String newTermOfContract;
}
