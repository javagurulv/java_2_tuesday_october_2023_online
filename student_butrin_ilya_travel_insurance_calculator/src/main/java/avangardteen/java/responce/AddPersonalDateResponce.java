package avangardteen.java.responce;

import avangardteen.java.CoreError;
import avangardteen.java.CoreResponce;

import java.util.List;

public class AddPersonalDateResponce extends CoreResponce {
    boolean isRequestEmty;
    public AddPersonalDateResponce() {
    }

    public AddPersonalDateResponce(List<CoreError> errorList) {
        super(errorList);
    }
}
