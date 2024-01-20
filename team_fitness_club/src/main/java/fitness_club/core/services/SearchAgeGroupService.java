package fitness_club.core.services;


import fitness_club.core.database.ClientRepository;
import fitness_club.core.database.jpa.JpaAgeGroupRepository;
import fitness_club.core.domain.AgeGroup;
import fitness_club.core.domain.Client;
import fitness_club.core.requests.Ordering;
import fitness_club.core.requests.Paging;
import fitness_club.core.requests.SearchAgeGroupRequest;
import fitness_club.core.requests.SearchClientRequest;
import fitness_club.core.responses.CoreError;
import fitness_club.core.responses.SearchAgeGroupResponse;
import fitness_club.core.responses.SearchClientResponse;
import fitness_club.core.services.validators.ageGroup.SearchAgeGroupRequestValidator;
import fitness_club.core.services.validators.client.SearchClientRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

