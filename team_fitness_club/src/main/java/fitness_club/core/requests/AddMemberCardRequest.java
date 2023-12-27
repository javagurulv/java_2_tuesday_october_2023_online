package fitness_club.core.requests;

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
    private String personalCode;
    private Long clientAgeGroups;
    private Long clientWorkout;
    private Long fitnessCentre;
    private Date termOfContract;
}
