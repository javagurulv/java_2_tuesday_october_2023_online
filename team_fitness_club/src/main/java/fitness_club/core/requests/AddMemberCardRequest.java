package fitness_club.core.requests;

import fitness_club.core.domain.AgeGroups;
import fitness_club.core.domain.Client;
import fitness_club.core.domain.FitnessCentres;
import fitness_club.core.domain.Workouts;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddMemberCardRequest {
    private Client client;
    private AgeGroups ageGroups;
    private Workouts workouts;
    private FitnessCentres fitnessCentre;
    private Date termOfContract;
}
