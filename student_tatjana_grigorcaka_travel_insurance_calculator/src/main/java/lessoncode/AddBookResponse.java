package lessoncode;

import java.util.List;

public class AddBookResponse  extends CoreResponse {


    public AddBookResponse(List<BusinessError> errors) {
        super(errors);
    }

    public AddBookResponse() {
        super(null);
    }

}
