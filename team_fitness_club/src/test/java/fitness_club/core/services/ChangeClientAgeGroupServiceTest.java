package fitness_club.core.services;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;


@Ignore
@RunWith(MockitoJUnitRunner.class)
public class ChangeClientAgeGroupServiceTest {
  /*  @Mock
    private Database database;

    @Mock
    private ChangeClientAgeGroupValidator validator;
    @InjectMocks
    private ChangeClientAgeGroupService service;


    @Test
    public void shouldChangeClientAgeGroupByPersonalCodeToNew() {
        ChangeClientAgeGroupRequest request = new ChangeClientAgeGroupRequest("1-2", ClientAgeGroups.ADULT);
        Mockito.when(validator.validate(request)).thenReturn(List.of());
        Mockito.when(database.clientAgeGroupChangedByPersonalCode("1-2", ClientAgeGroups.ADULT)).thenReturn(true);
        ChangeClientAgeGroupResponse response = service.execute(request);
        Assert.assertTrue(!response.hasErrors());
        Assert.assertTrue(response.isClientAgeGroupChanged());
    }

    */
}
