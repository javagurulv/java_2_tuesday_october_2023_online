package classWork.core.service.valigators;

import classWork.core.CoreError;
import classWork.core.requests.SearchBooksRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Component
public class SearchBooksFieldValidator {
    public List<CoreError> errorList(SearchBooksRequest request) {
        List<CoreError> errorList = new ArrayList<>();
        twoFieldIsEmpty(request).ifPresent(errorList::add);
        return errorList;
    }

    public Optional<CoreError> twoFieldIsEmpty(SearchBooksRequest request) {
        Optional<CoreError> error = request.getAuthor().isEmpty() && request.getTitle().isEmpty()
                ? Optional.of(new CoreError("Автор и название", "Имейте совесть. Хоть одно поле надо заполнить"))
                : Optional.empty();
        return error;
    }
}