package fitness_club.core.requests;

import fitness_club.core.domain.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class MemberCardRegistrationRequest {

    private MemberCard memberCard;
    private String client;
    private Long ageGroup;
    private Long workout;
    private Long fitnessCenter;
    private String termOfContract;

    public MemberCardRegistrationRequest(String client, Long ageGroup, Long workout, Long fitnessCenter, String termOfContract) {
    }

    public MemberCardRegistrationRequest(MemberCard memberCard) {
    }
}
