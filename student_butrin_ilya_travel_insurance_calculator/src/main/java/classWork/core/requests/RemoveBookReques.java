package classWork.core.requests;

import classWork.core.service.valigators.AddBookValidator;

public class RemoveBookReques {
    AddBookValidator validator;
    long id;

    public RemoveBookReques(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
