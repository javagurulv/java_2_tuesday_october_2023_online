package classWork.core.service.valigators;

import classWork.core.CoreError;
import classWork.core.requests.Ordering;
import classWork.core.requests.SearchBooksRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SearchBookOrderingValigator {
    public List<CoreError> errorList(Ordering ordering) {
        List<CoreError> errorList = new ArrayList<>();
        orderBy(ordering).ifPresent(errorList::add);
        orderDirection(ordering).ifPresent(errorList::add);
        orderByAndDirection(ordering).ifPresent(errorList::add);
        return errorList;
    }

    public Optional<CoreError> orderByAndDirection(Ordering ordering) {
        if (!ordering.getOrderBy().isEmpty() && ordering.getOrderDirection().isEmpty()
                || ordering.getOrderBy().isEmpty() && !ordering.getOrderDirection().isEmpty()) {
            return Optional.of(new CoreError("сортировка", "запоните оба поля сортировки или оставте оба поля пустыми"));
        } else {
            return Optional.empty();
        }
    }

    public Optional<CoreError> orderBy(Ordering ordering) {
        if (!ordering.equals("по автору") && !ordering.getOrderBy().equals("по названию"))
            if (!ordering.getOrderBy().isEmpty()) {
                return Optional.of(new CoreError("сортировка(критерий)", "введите \"по автору\" или \"по названию\""));
            }
        return Optional.empty();
    }

    public Optional<CoreError> orderDirection(Ordering ordering) {
        if (!ordering.getOrderDirection().equals("по возрастанию") && !ordering.getOrderDirection().equals("по убыванию"))
            if (!ordering.getOrderDirection().isEmpty()) {
                return Optional.of(new CoreError("сортировка(возр/убыв)", "введите \"по возрастанию\" или \"по убыванию\""));
            }
        return Optional.empty();
    }
}


