package classWork.core.service.valigators;

import classWork.core.CoreError;
import classWork.core.database.Database;
import classWork.core.requests.AddBookRequest;
import classWork.dependency_injection.DIComponent;
import classWork.dependency_injection.DIDependency;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DIComponent
public class AddBookValidator {
   @DIDependency Database data;


    public List<CoreError> errorlist (AddBookRequest request){
        List<CoreError> errorList;
        errorList = new ArrayList<>();
        errorTittle(request).ifPresent(errorList::add);
        errorAuthor(request).ifPresent(errorList::add);
        errorRepeat(request).ifPresent(errorList::add);
        return errorList;
    }

    public Optional<CoreError> errorTittle (AddBookRequest request) {
        return request.getTitle().isEmpty()||request.getTitle() ==null
                ? Optional.of(new CoreError("название: ", "необходимо ввести название книги"))
                : Optional.empty();}

    public  Optional<CoreError> errorAuthor (AddBookRequest request) {

        Optional<CoreError> err = request.getAuthor().isEmpty()||request.getAuthor() ==null
                ? Optional.of(new CoreError("автор: ", "необходимо ввести автора книги"))
                : Optional.empty();
        return err;
    }
    public Optional<CoreError> errorRepeat (AddBookRequest request) {

        boolean rez = data.repeatBook(request.getTitle(), request.getAuthor());
        Optional<CoreError> err = rez
                ? Optional.of(new CoreError("книга: ", "Такая книга уже есть"))
                : Optional.empty();
        return err;

    }

}
