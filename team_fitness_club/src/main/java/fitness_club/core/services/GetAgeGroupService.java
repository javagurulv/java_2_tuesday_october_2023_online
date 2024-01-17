package fitness_club.core.services;

import fitness_club.core.database.AgeGroupRepository;
import fitness_club.core.requests.GetAgeGroupRequest;
import fitness_club.core.responses.CoreError;
import fitness_club.core.responses.GetAgeGroupResponse;
import fitness_club.core.services.validators.ageGroup.GetAgeGroupRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class GetAgeGroupService {

    @Autowired
    private AgeGroupRepository ageGroupsRepository;

    @Autowired
    private GetAgeGroupRequestValidator validator;

    public GetAgeGroupResponse execute(GetAgeGroupRequest request) {
        List<CoreError> errors = validator.validate(request);
        if (!errors.isEmpty()) {
            return new GetAgeGroupResponse();
        }
        return ageGroupsRepository.getById(request.getId())
                .map(GetAgeGroupResponse::new)
                .orElseGet(()->{
                    errors.add(new CoreError("id", "Not found!"));
                            return new GetAgeGroupResponse(errors);
                        });
    }
}
