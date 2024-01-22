package fitness_club.core.requests;

import fitness_club.core.domain.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class MemberCardRegistrationFormRequest {

    private MemberCard memberCard;
    private Long client;
    private Long ageGroup;
    private Long workout;
    private Long fitnessCenter;
    private String termOfContract;

    public MemberCardRegistrationFormRequest(Long client, Long ageGroup, Long workout, Long fitnessCenter, String termOfContract) {
    }

    public MemberCardRegistrationFormRequest(MemberCard memberCard) {
    }
}
