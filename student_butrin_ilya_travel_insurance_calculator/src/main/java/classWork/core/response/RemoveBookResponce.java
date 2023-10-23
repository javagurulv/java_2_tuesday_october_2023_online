package classWork.core.response;


import java.util.List;

import classWork.core.CoreError;
import classWork.core.CoreResponse;

public class RemoveBookResponce extends CoreResponse {
    Boolean IsBookDeleted;

    public RemoveBookResponce(List<CoreError> errors) {
        super(errors);
    }


    public RemoveBookResponce(boolean isBookDeleted) {
        IsBookDeleted = isBookDeleted;
    }
    public Boolean getBookDeleted() {
        return IsBookDeleted;
    }
}
