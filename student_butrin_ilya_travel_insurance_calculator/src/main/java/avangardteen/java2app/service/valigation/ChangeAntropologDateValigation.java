package avangardteen.java2app.service.valigation;

import avangardteen.java2app.CoreError;
import avangardteen.java2app.dependency_injection.DIComponent;
import avangardteen.java2app.request.ChangeAntropologDateRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@DIComponent
public class ChangeAntropologDateValigation {

    public  List<CoreError> errorlist (ChangeAntropologDateRequest request) {
        List<CoreError> errorList = new ArrayList<>();
        emptyField(request).ifPresent(errorList::add);;
        veryLong(request).ifPresent(errorList::add);
        verysSmall(request).ifPresent(errorList::add);
        return errorList;
    }
    public Optional<CoreError> emptyField(ChangeAntropologDateRequest reqest) {
        Optional<CoreError> err;
        if (reqest.getMeaning().isEmpty() || reqest.getMeaning() == null) {
           err =  Optional.of(new CoreError("новое значение", "Вы забыли заполнить замеры спины"));
        } else err = Optional.empty();
        return err;

    }
    public Optional<CoreError> veryLong(ChangeAntropologDateRequest reqest) {
        Optional<CoreError> err;
        if (!reqest.getMeaning().isEmpty() && Integer.parseInt(reqest.getMeaning())
                > 100) {
            err =  Optional.of(new CoreError("новое значение", "что-то многовато. Надо бы перемерить"));
        } else err = Optional.empty();
        return err;
    }
    public Optional<CoreError> verysSmall(ChangeAntropologDateRequest reqest) {
        Optional<CoreError> err;
        if (!reqest.getMeaning().isEmpty() && Integer.parseInt(reqest.getMeaning())
                < 10) {
            err =  Optional.of(new CoreError("новое значение", "как-то мало Вы намерили. Надо бы перемерить"));
        } else err = Optional.empty();
        return err;
    }
}

