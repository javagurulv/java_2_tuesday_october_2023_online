package classWork.core.service.valigators;

import classWork.core.CoreError;
import classWork.core.requests.RemoveBookReques;
import classWork.dependency_injection.DIComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@DIComponent
public class RemoveBookValidators {
    public List<CoreError> errorList (RemoveBookReques request){
        List<CoreError> errors = new ArrayList<>();
        idEmpty(request).ifPresent(errors::add);
        return  errors;
    }
    public Optional<CoreError> idEmpty (RemoveBookReques request){
        return request.getId() == 0L
                    ? Optional.of(new CoreError("ИД: ", "необходимо ввести ИД книги"))
                    : Optional.empty();
    }
}
