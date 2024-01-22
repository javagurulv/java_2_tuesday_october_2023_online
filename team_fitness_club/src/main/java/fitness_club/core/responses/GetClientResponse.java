package fitness_club.core.responses;

import fitness_club.core.domain.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetClientResponse extends CoreResponse {
    private Client client;

    public GetClientResponse(List<CoreError> errors) {
        super(errors);
    }
}
