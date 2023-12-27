package fitness_club.core.requests;

import fitness_club.core.domain.Client;
import fitness_club.core.domain.ClientAgeGroups;
import fitness_club.core.domain.FitnessCentre;
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
    private String clientAgeGroups;
    private String workouts;
    private String fitnessCentre;
    private Date termOfContract;
}
