package fitness_club.core.services;

import fitness_club.core.database.jpa.JpaMemberCardRepository;
import fitness_club.core.domain.*;
import fitness_club.core.requests.MemberCardRegistrationFormRequest;
import fitness_club.core.responses.MemberCardRegistrationFormResponse;
import fitness_club.core.responses.CoreError;
import fitness_club.core.services.validators.memberCard.MemberCardRegistrationFormRequestValidator;

import org.junit.Ignore;
import org.junit.Test;

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
@Ignore
@RunWith(MockitoJUnitRunner.class)
public class MemberCardRegistrationServiceTest {
/*
    @Mock
    private JpaMemberCardRepository memberCardRepository;

    @Mock
    private MemberCardRegistrationFormRequestValidator validator;
    @InjectMocks
    private MemberCardRegistrationFormService service;

    @Test
    public void shouldReturnResponseWithErrorsWhenValidationFails() {

        MemberCard memberCard = new MemberCard(null, 1L, 2L, 1L);

        MemberCardRegistrationFormRequest notValidRequest = new MemberCardRegistrationFormRequest(memberCard);
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("clientId",
                "Field client ID must not be empty!")));
        MemberCardRegistrationFormResponse response = service.execute(notValidRequest);
        assertTrue(response.hasErrors());
    }

    @Test
    public void shouldReturnResponseWithErrorsReceivedFromValidator() {

        MemberCard memberCard = new MemberCard(null, 1L, 2L, 1L);

        MemberCardRegistrationFormRequest notValidRequest = new MemberCardRegistrationFormRequest(memberCard);
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("clientId",
                "Field client ID must not be empty!")));
        MemberCardRegistrationFormResponse response = service.execute(notValidRequest);
        assertEquals(response.getErrors().size(), 1);
        assertEquals(response.getErrors().get(0).getField(), "clientId");
        assertEquals(response.getErrors().get(0).getMessage(), "Field client ID must not be empty!");
    }

  /*  @Test
    public void addMemberCardShouldSuccess_Mockito_style() {

        MemberCard memberCard = new MemberCard(1L, 1L, 2L, 1L);

        MemberCardRegistrationRequest request = new MemberCardRegistrationRequest(memberCard);
        when(validator.validate(request)).thenReturn(List.of());
        MemberCardRegistrationResponse response = service.execute(request);
        assertFalse(response.hasErrors());
        verify(memberCardRepository).save(any());
    }



    @Test
    public void shouldNotInvokeDatabaseWhenRequestValidationFails() {
        MemberCard memberCard = new MemberCard(null, 1L, 2L, 1L);

        MemberCardRegistrationFormRequest notValidRequest = new MemberCardRegistrationFormRequest(memberCard);
        when(validator.validate(notValidRequest)).thenReturn(List.of(new CoreError("clientId",
                "Field client ID must not be empty!")));
        service.execute(notValidRequest);
        verifyNoInteractions(memberCardRepository);
    }

 */


    /*@Test
    public void shouldNotReturnResponseWithoutErrorsWhenRequestIsValid() {


        MemberCard memberCard = new MemberCard(1L, 1L, 2L, 1L);

        MemberCardRegistrationRequest validRequest = new MemberCardRegistrationRequest(memberCard);
        when(validator.validate(validRequest)).thenReturn(List.of());

        MemberCardRegistrationResponse response = service.execute(validRequest);
        assertFalse(response.hasErrors());
    }

     */
}