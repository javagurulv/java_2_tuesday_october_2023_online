package classWork.core.service.valigators;

import classWork.core.CoreError;
import classWork.core.requests.SearchBooksRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Component
public class SearchBookValigator {
    @Autowired
  SearchBooksFieldValidator field;
    @Autowired  SearchBookOrderingValigator ordering;
    @Autowired SearchBookPagingValigator paging;

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