package fitness_club.core.responses;

import lombok.*;

import java.util.List;
@Getter
@NoArgsConstructor
public class MemberCardRegistrationFormResponse extends CoreResponse {

    public MemberCardRegistrationFormResponse(List<CoreError> errors) {
        super(errors);
    }

}
