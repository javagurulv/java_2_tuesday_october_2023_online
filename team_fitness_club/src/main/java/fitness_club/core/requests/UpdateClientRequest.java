package fitness_club.core.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateClientRequest {

    private Long Id;

    private String newName;

    private String newLastName;

    private String newPersonalCode;
}
