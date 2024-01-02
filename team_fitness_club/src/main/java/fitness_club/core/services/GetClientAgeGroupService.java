package fitness_club.core.services;

import fitness_club.core.database.AgeGroupsRepository;
import fitness_club.core.domain.AgeGroups;
import fitness_club.core.domain.Client;
import fitness_club.core.requests.GetAllClientsRequest;
import fitness_club.core.requests.GetClientAgeGroupRequest;
import fitness_club.core.responses.GetAllClientsResponse;
import fitness_club.core.responses.GetClientAgeGroupResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class GetClientAgeGroupService {

    @Autowired
    private AgeGroupsRepository ageGroupsRepository;

    public GetClientAgeGroupResponse execute(GetClientAgeGroupRequest request) {
        List<AgeGroups> ageGroups = ageGroupsRepository.getAllAgeGroups();
        return new GetClientAgeGroupResponse(ageGroups);
    }
}
