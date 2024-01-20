package fitness_club.core.services;

import fitness_club.core.database.AgeGroupRepositoryImpl;
import fitness_club.core.database.jpa.JpaAgeGroupRepository;
import fitness_club.core.domain.AgeGroup;
import fitness_club.core.requests.GetAllAgeGroupsRequest;
import fitness_club.core.responses.GetAllAgeGroupsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class GetAllAgeGroupsService {

    @Autowired
    private JpaAgeGroupRepository ageGroupsRepository;

    public GetAllAgeGroupsResponse execute(GetAllAgeGroupsRequest request) {
        List<AgeGroup> ageGroups = ageGroupsRepository.findAll();
        return new GetAllAgeGroupsResponse(ageGroups);
    }
}
