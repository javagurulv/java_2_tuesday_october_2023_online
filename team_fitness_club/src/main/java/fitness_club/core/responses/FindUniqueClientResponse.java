package fitness_club.core.responses;

import java.util.List;

public class FindUniqueClientResponse extends CoreResponse {

    private boolean clientFound;

    public FindUniqueClientResponse(List<CoreError> errors) {
        super(errors);
    }

    public FindUniqueClientResponse(boolean clientFound) {
        this.clientFound = clientFound;
    }

    public boolean isClientFound() {
        return clientFound;
    }
}
