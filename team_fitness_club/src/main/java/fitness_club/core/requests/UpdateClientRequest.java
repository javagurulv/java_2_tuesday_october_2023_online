package fitness_club.core.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateClientRequest {

    private Long id;

    private String newFirstName;

    private String newLastName;

    private String newPersonalCode;
}
