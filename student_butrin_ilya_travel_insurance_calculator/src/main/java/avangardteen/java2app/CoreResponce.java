package avangardteen.java2app;

import java.util.List;

public class CoreResponce {
    List<CoreError> errorList;

    public CoreResponce() {
    }
    public CoreResponce(List<CoreError> errorList) {
        this.errorList = errorList;
    }

    public List<CoreError> getErrorList() {
        return errorList;
    }
    public boolean hasErrors() {
        return errorList != null && !errorList.isEmpty();
    }
}
