package fitness_club.core.responses;

import lombok.*;

import java.util.List;

public class MemberCardRegistrationResponse extends CoreResponse {

    public MemberCardRegistrationResponse(List<CoreError> errors) {
        super(errors);
    }

}
