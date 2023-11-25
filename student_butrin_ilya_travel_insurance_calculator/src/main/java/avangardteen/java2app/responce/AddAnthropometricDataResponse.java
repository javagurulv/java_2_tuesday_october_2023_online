package avangardteen.java2app.responce;



import avangardteen.java2app.CoreResponce;
import avangardteen.java2app.CoreError;

import java.util.List;

public class AddAnthropometricDataResponse extends CoreResponce {
    public AddAnthropometricDataResponse(List<CoreError> errors) {
        super(errors);
    }

    public AddAnthropometricDataResponse() {
    }
}
