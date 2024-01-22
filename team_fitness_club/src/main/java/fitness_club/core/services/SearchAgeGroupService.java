package fitness_club.core.services;


import fitness_club.core.database.jpa.JpaAgeGroupRepository;
import fitness_club.core.domain.AgeGroup;
import fitness_club.core.requests.SearchAgeGroupRequest;
import fitness_club.core.responses.CoreError;
import fitness_club.core.responses.SearchAgeGroupResponse;
import fitness_club.core.services.validators.ageGroup.SearchAgeGroupRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class SearchAgeGroupService {
    @Value("${search.ordering.enabled}")
    private boolean orderingEnabled;

    @Value("${search.paging.enabled}")
    private boolean pagingEnabled;

    @Autowired
    private JpaAgeGroupRepository ageGroupRepository;
    @Autowired
    private SearchAgeGroupRequestValidator validator;


    public SearchAgeGroupResponse execute(SearchAgeGroupRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new SearchAgeGroupResponse(null, errors);
        }

        List<AgeGroup> foundAgeGroup = search(request);

        return new SearchAgeGroupResponse(foundAgeGroup, null);
    }

    private List<AgeGroup> search(SearchAgeGroupRequest request) {
        List<AgeGroup> foundAgeGroups = new ArrayList<>();
        if (request.isAgeGroupProvided()) {
            foundAgeGroups = ageGroupRepository.findByAgeGroup(request.getAgeGroup());
        }
        return foundAgeGroups;
    }

}

