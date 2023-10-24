package avangardteen.java.service.valigation;

import avangardteen.java.CoreError;
import avangardteen.java.request.AddAnthropometricDataRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



public class AddAntropologDateValigation {

    public  List<CoreError> errorlist (AddAnthropometricDataRequest request) {
        List<CoreError> errorList = new ArrayList<>();
        emptyFieldBackLength(request).ifPresent(errorList::add);
        emptyFieldPelvichWidth(request).ifPresent(errorList::add);
        emptyFieldShinLength(request).ifPresent(errorList::add);
        emptyFieldThighLength(request).ifPresent(errorList::add);
        veryLongBackLength(request).ifPresent(errorList::add);
        veryLongPelvichWidth(request).ifPresent(errorList::add);
        veryLongShinLength(request).ifPresent(errorList::add);
        veryLongThighLength(request).ifPresent(errorList::add);
        return errorList;
    }
    public Optional<CoreError> emptyFieldBackLength(AddAnthropometricDataRequest reqest) {
        Optional<CoreError> err;
        if (reqest.getBackLength() == 0) {
           err =  Optional.of(new CoreError("Высота спины", "Вы забыли заполнить замеры спины"));
        } else err = Optional.empty();
        return err;
    }
    public Optional<CoreError> emptyFieldPelvichWidth(AddAnthropometricDataRequest reqest) {
        Optional<CoreError> err;
        if (reqest.getPelwicWidth() == 0) {
            err =  Optional.of(new CoreError("ширина таза", "Вы забыли замерить ширину таза"));
        } else err = Optional.empty();
        return err;
    }
    public Optional<CoreError> emptyFieldShinLength(AddAnthropometricDataRequest reqest) {
        Optional<CoreError> err;
        if (reqest.getShinLength() == 0) {
            err =  Optional.of(new CoreError("длинна голени", "Вы забыли измерить длинну голени"));
        } else err = Optional.empty();
        return err;
    }
    public Optional<CoreError> emptyFieldThighLength(AddAnthropometricDataRequest reqest) {
        Optional<CoreError> err;
        if (reqest.getThighLength() == 0) {
            err =  Optional.of(new CoreError("длинна бедра", "Вы забыли замерить длинну бедра"));
        } else err = Optional.empty();
        return err;
    }
    public Optional<CoreError> veryLongBackLength(AddAnthropometricDataRequest reqest) {
        Optional<CoreError> err;
        if (reqest.getBackLength() > 100) {
            err =  Optional.of(new CoreError("Высота спины", "что-то многовато. Надо бы перемерить"));
        } else err = Optional.empty();
        return err;
    }
    public Optional<CoreError> veryLongThighLength(AddAnthropometricDataRequest reqest) {
        Optional<CoreError> err;
        if (reqest.getThighLength() > 100) {
            err =  Optional.of(new CoreError("длинна бедра", "что-то многовато. Надо бы перемерить"));
        } else err = Optional.empty();
        return err;
    }
    public Optional<CoreError> veryLongShinLength(AddAnthropometricDataRequest reqest) {
        Optional<CoreError> err;
        if (reqest.getShinLength() >100 ) {
            err =  Optional.of(new CoreError("длинна голени", "что-то многовато. Надо бы перемерить"));
        } else err = Optional.empty();
        return err;
    }
    public Optional<CoreError> veryLongPelvichWidth(AddAnthropometricDataRequest reqest) {
        Optional<CoreError> err;
        if (reqest.getPelwicWidth() >100) {
            err =  Optional.of(new CoreError("ширина таза", "что-то многовато. Надо бы перемерить"));
        } else err = Optional.empty();
        return err;
    }
}

