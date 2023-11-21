package avangardteen.java2app.responce;

import avangardteen.java2app.CoreError;
import avangardteen.java2app.CoreResponce;

import java.util.List;

public class AddPersonalDateResponce extends CoreResponce {
    boolean isRequestEmty;
    public AddPersonalDateResponce() {
    }

    public AddPersonalDateResponce(List<CoreError> errorList) {
        super(errorList);
    }
}
