package fitness_club.core.requests;

import fitness_club.core.domain.AgeGroup;
import fitness_club.core.domain.Client;
import fitness_club.core.domain.FitnessCenter;
import fitness_club.core.domain.Workout;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMemberCardRequest {

    private Long Id;
    private Client newClient;
    private AgeGroup newAgeGroup;
    private Workout newWorkout;
    private FitnessCenter newFitnessCenter;
    private Date newTermOfContract;
}
