package classWork.core.service.valigators;

import classWork.core.CoreError;
import classWork.core.requests.SearchBooksRequest;
import classWork.dependency_injection.DIComponent;
import classWork.dependency_injection.DIDependency;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@DIComponent
public class SearchBookValigator {
  @DIDependency
  SearchBooksFieldValidator field = new SearchBooksFieldValidator();
  @DIDependency  SearchBookOrderingValigator ordering = new SearchBookOrderingValigator();
  @DIDependency SearchBookPagingValigator paging = new SearchBookPagingValigator();

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