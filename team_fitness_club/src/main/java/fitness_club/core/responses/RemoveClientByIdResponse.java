package fitness_club.core.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RemoveClientByIdResponse extends CoreResponse {

    private boolean removeClient;


    public RemoveClientByIdResponse(List<CoreError> errors) {
        super(errors);
    }

    public boolean isClientRemoved() {
        return removeClient;
    }
}
