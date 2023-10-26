package fitness_club.data_vlidation;

import fitness_club.core.requests.Paging;
import fitness_club.core.requests.SearchClientRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SearchClientRequestValidator {

    public List<CoreError> validate(SearchClientRequest request) {
        List<CoreError> errors = new ArrayList<>();
        errors.addAll(validateSearchFields(request));
        if (request.getPaging() != null) {
            validatePageNumberIsNotEmpty(request.getPaging()).ifPresent(errors::add);
            validatePageSizeIsNotEmpty(request.getPaging()).ifPresent(errors::add);
            validatePageSize(request.getPaging()).ifPresent(errors::add);
            validatePageNumber(request.getPaging()).ifPresent(errors::add);
        }
        return errors;
    }

    private List<CoreError> validateSearchFields(SearchClientRequest request) {
        List<CoreError> errors = new ArrayList<>();
        if (isEmpty(request.getFirstName()) && isEmpty(request.getLastName())) {
            errors.add(new CoreError("firstName", "Must not be empty!"));
            errors.add(new CoreError("lastName", "Must not be empty!"));
        }
        return errors;
    }

    private Optional<CoreError> validatePageNumberIsNotEmpty(Paging paging) {
        return (paging.getPageNumber() == null && paging.getPageSize() != null)
                ? Optional.of(new CoreError("pageNumber", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validatePageSizeIsNotEmpty(Paging paging) {
        return (paging.getPageSize() == null && paging.getPageNumber() != null)
                ? Optional.of(new CoreError("pageSize", "Must not be empty!"))
                : Optional.empty();
    }

    private Optional<CoreError> validatePageNumber(Paging paging) {
        return (paging.getPageNumber() != null
                && paging.getPageNumber() <= 0)
                ? Optional.of(new CoreError("pageNumber", "Must be greater then 0!"))
                : Optional.empty();
    }

    private Optional<CoreError> validatePageSize(Paging paging) {
        return (paging.getPageSize() != null
                && paging.getPageSize() <= 0)
                ? Optional.of(new CoreError("pageSize", "Must be greater then 0!"))
                : Optional.empty();
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }
}
