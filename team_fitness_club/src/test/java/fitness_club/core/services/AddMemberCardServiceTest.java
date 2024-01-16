package fitness_club.core.services;

import fitness_club.core.database.MemberCardRepository;
import fitness_club.core.domain.*;
import fitness_club.core.requests.AddMemberCardRequest;
import fitness_club.core.responses.AddMemberCardResponse;
import fitness_club.core.responses.CoreError;
import fitness_club.core.services.vlidators.AddMemberCardRequestValidator;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AddMemberCardServiceTest {

    @Mock
    private MemberCardRepository memberCardRepository;

    @Mock
    private AddMemberCardRequestValidator validator;
    @InjectMocks
    private AddMemberCardService service;

    @Test
    public void shouldReturnResponseWithErrorsWhenValidationFails() {

        MemberCard memberCard = new MemberCard(null, 1L, 2L, 1L);

        AddMemberCardRequest notValidRequest = new AddMemberCardRequest(memberCard);
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("clientId",
                "Field client ID must not be empty!")));
        AddMemberCardResponse response = service.execute(notValidRequest);
        assertTrue(response.hasErrors());
    }

    @Test
    public void shouldReturnResponseWithErrorsReceivedFromValidator() {

        MemberCard memberCard = new MemberCard(null, 1L, 2L, 1L);

        AddMemberCardRequest notValidRequest = new AddMemberCardRequest(memberCard);
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("clientId",
                "Field client ID must not be empty!")));
        AddMemberCardResponse response = service.execute(notValidRequest);
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getField(), "clientId");
        assertEquals(response.getErrors().get(0).getMessage(), "Field client ID must not be empty!");
    }

    @Test
    public void addMemberCardShouldSuccess_Mockito_style() {

        MemberCard memberCard = new MemberCard(1L, 1L, 2L, 1L);

        AddMemberCardRequest request = new AddMemberCardRequest(memberCard);
        when(validator.validate(request)).thenReturn(List.of());
        AddMemberCardResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        verify(memberCardRepository).save(any());
    }

    @Test
    public void shouldNotInvokeDatabaseWhenRequestValidationFails() {
        MemberCard memberCard = new MemberCard(null, 1L, 2L, 1L);

        AddMemberCardRequest notValidRequest = new AddMemberCardRequest(memberCard);
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("clientId",
                "Field client ID must not be empty!")));
        service.execute(notValidRequest);
        verifyNoInteractions(memberCardRepository);
    }

    @Test
    public void shouldReturnResponseWithoutErrorsWhenRequestIsValid() {
        MemberCard memberCard = new MemberCard(1L, 1L, 2L, 1L);

        AddMemberCardRequest validRequest = new AddMemberCardRequest(memberCard);
        when(validator.validate(validRequest)).thenReturn(List.of());
        AddMemberCardResponse response = service.execute(validRequest);
        assertFalse(response.hasErrors());
    }
    @Test
    public void shouldReturnResponseWithMemberCardWhenRequestIsValid() {


        MemberCard memberCard = new MemberCard(1L, 1L, 2L, 1L);

        AddMemberCardRequest validRequest = new AddMemberCardRequest(memberCard);
        when(validator.validate(validRequest)).thenReturn(List.of());

        AddMemberCardResponse response = service.execute(validRequest);
        assertNotNull(response.getNewMemberCard());
        Assertions.assertEquals(response.getNewMemberCard().getClient(), validRequest.getClient());
        Assertions.assertEquals(response.getNewMemberCard().getAgeGroup(), validRequest.getAgeGroup());
        Assertions.assertEquals(response.getNewMemberCard().getFitnessCentre(), validRequest.getFitnessCentre());
        Assertions.assertEquals(response.getNewMemberCard().getWorkout(), validRequest.getWorkout());
    }
}