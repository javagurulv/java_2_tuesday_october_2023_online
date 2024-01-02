package fitness_club.core.services;

import fitness_club.core.database.AgeGroupsRepository;
import fitness_club.core.domain.AgeGroups;
import fitness_club.core.requests.GetAgeGroupRequest;
import fitness_club.core.responses.GetAgeGroupResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class GetAgeGroupService {

    @Autowired
    private AgeGroupsRepository ageGroupsRepository;

    public GetAgeGroupResponse execute(GetAgeGroupRequest request) {
        List<AgeGroups> ageGroups = ageGroupsRepository.getAllAgeGroups();
        return new GetAgeGroupResponse(ageGroups);
    }
}
