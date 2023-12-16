package fitness_club.core.requests;

import fitness_club.core.domain.ClientAgeGroups;
import fitness_club.core.domain.FitnessCentre;
import fitness_club.core.domain.Workouts;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddClientRequest {

    private String firstName;
    private String lastName;
    private String personalCode;
    //private ClientAgeGroups clientAgeGroup;
    //private Workouts workout;
    //private FitnessCentre fitnessCentre;

}
