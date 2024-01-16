package fitness_club.core.requests;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

public class ChangeClientFitnessCenterRequest {

    private Long clientId;
    private Long fitnessCenterId;

}
