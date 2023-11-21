package classWork.core.service.valigators;

import classWork.core.CoreError;
import classWork.core.requests.Paging;
import classWork.core.requests.SearchBooksRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SearchBookPagingValigator {
    public List<CoreError> errorList(Paging paging) {
        List<CoreError> errorList = new ArrayList<>();
        pageSizeAndNubmerEmpty(paging).ifPresent(errorList::add);
        pageNubmerless1(paging).ifPresent(errorList::add);
        pageSizeless1(paging).ifPresent(errorList::add);
        return errorList;
    }

    public Optional<CoreError> pageSizeAndNubmerEmpty(Paging paging) {
        if (paging.getPageSize() != null && paging.getPageNumber() == null
                || paging.getPageSize() == null && paging.getPageNumber() != null) {
            return Optional.of(new CoreError("страница", "запоните оба поля сортировки или оставте оба поля пустыми"));
        } else {
            return Optional.empty();
        }
    }

    public Optional<CoreError> pageSizeless1(Paging paging) {
        if (paging.getPageSize() != null &&paging.getPageSize() <= 0)
            return Optional.of(new CoreError("размер страницы", "количество книг на странице должно быть более 0"));
        else return Optional.empty();

    }

    public Optional<CoreError> pageNubmerless1(Paging paging) {
        if (paging.getPageNumber() != null && paging.getPageNumber() <= 0)
            return Optional.of(new CoreError("номер страницы", "Номер страницы доджен быть больше 0"));
        else return Optional.empty();
    }
}
