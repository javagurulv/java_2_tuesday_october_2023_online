package fitness_club.core.responses;

import fitness_club.core.domain.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateClientResponse extends CoreResponse {
    private Client updateClient;

    public UpdateClientResponse(List<CoreError> errors) {
        super(errors);
    }


}
