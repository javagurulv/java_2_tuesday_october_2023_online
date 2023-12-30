package fitness_club.core.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterClientRequest {

    private String firstName;

    private String lastName;

    private String personalCode;
}
