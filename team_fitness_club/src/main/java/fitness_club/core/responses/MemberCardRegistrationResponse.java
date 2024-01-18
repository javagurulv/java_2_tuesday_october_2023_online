package fitness_club.core.responses;

import lombok.*;

import java.util.List;
@Getter
@NoArgsConstructor
public class MemberCardRegistrationResponse extends CoreResponse {

    public MemberCardRegistrationResponse(List<CoreError> errors) {
        super(errors);
    }

}
