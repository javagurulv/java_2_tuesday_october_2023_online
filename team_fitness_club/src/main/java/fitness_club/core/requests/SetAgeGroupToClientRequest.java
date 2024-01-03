package fitness_club.core.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SetAgeGroupToClientRequest {

    private Long clientId;
    private Long ageGroupId;

}
