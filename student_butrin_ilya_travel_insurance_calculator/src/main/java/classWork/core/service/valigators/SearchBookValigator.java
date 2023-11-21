package classWork.core.service.valigators;

import classWork.core.CoreError;
import classWork.core.requests.SearchBooksRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SearchBookValigator {
    SearchBooksFieldValidator field = new SearchBooksFieldValidator();
    SearchBookOrderingValigator ordering = new SearchBookOrderingValigator();
    SearchBookPagingValigator paging = new SearchBookPagingValigator();

    public SearchBookValigator(SearchBooksFieldValidator field, SearchBookOrderingValigator ordering, SearchBookPagingValigator paging) {
        this.field = field;
        this.ordering = ordering;
        this.paging = paging;
    }

    public List<CoreError> errorList(SearchBooksRequest request) {
        List<CoreError> errorList = new ArrayList<>();

        errorList.addAll(field.errorList(request));
        if(request.getOrdering() != null) {
        errorList.addAll(ordering.errorList(request.getOrdering()));
        }
        if(request.getPadding() != null)
errorList.addAll(paging.errorList(request.getPadding()));
        return errorList;
    }

    }