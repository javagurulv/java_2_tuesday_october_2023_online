package fitness_club.core.services.data_vlidation;

import fitness_club.core.requests.Paging;
import fitness_club.dependency_injection.DIComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DIComponent
public class PagingValidator {

    public List<CoreError> validate(Paging paging) {
        List<CoreError> errors = new ArrayList<>();
        validatePageNumberIsNotEmpty(paging).ifPresent(errors::add);
        validatePageSizeIsNotEmpty(paging).ifPresent(errors::add);
        validatePageNumber(paging).ifPresent(errors::add);
        validatePageSize(paging).ifPresent(errors::add);
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
}
