package fitness_club.core.services;

import fitness_club.core.database.AgeGroupsRepository;
import fitness_club.core.domain.AgeGroups;
import fitness_club.core.requests.GetAgeGroupRequest;
import fitness_club.core.responses.*;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@Ignore
@RunWith(MockitoJUnitRunner.class)
public class GetClientAgeGroupServiceTest {
/*
    @Mock
    private AgeGroupsRepository ageGroupsRepository;

    @InjectMocks
    private GetAgeGroupService service;


    @Test
    public void shouldGetAgeGroupsFromDb() {

        List<AgeGroups> ageGroups = List.of(
                new AgeGroups("CHILD"),
                new AgeGroups("ADULT"),
                new AgeGroups("SENIOR"));
        Mockito.when(ageGroupsRepository.getAllAgeGroups()).thenReturn(ageGroups);
        GetAgeGroupRequest request = new GetAgeGroupRequest();
        GetAgeGroupResponse response = service.execute(request);
        assertEquals(response.getAgeGroups().size(), 3);
        assertEquals(response.getAgeGroups().get(0).getAgeGroup(), "CHILD");
        assertEquals(response.getAgeGroups().get(1).getAgeGroup(), "ADULT");
        assertEquals(response.getAgeGroups().get(2).getAgeGroup(), "SENIOR");
    }

 */

}