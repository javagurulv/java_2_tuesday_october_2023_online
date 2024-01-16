package fitness_club.core.requests;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ChangeClientAgeGroupRequest {

    private Long clientId;
    private Long clientAgeGroupId;

}
